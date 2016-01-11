package model;

import java.sql.*;

/**
 * Created by Jack Lee on 2016/1/4.
 */
public class MySQL {
    //
    private String url;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ArticleList articleList = new ArticleList();

    //MySQL
    public MySQL(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    //
    public void Connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, user, password);
    }

    //
    public void getUserInfo(){

    }

    //
    public boolean addArticle(Article article) throws Exception {
        this.statement = connection.createStatement();

        String sqlStr = "INSERT INTO article(topic, title, summary, content, img) values("
                + article.getTopic() + ", "
                + "'" + article.getTitle() + "', '"
                + article.getSummary() + "', '"
                + article.getContent() + "', '"
                + article.getImg() + "')";
        statement.executeUpdate(sqlStr);

        return true;
    }

    //
    public boolean removeArticle(int index) throws Exception {
        this.statement = connection.createStatement();

        String sqlStr = "DELETE FROM article WHERE id = " + index;
        statement.executeUpdate(sqlStr);

        return true;
    }

    //
    public boolean modifyArticle(Article article) throws Exception {
        this.statement = connection.createStatement();
        String sqlStr = "UPDATE article SET title = '"  + article.getTitle() + "', content = '"
                + article.getContent() + "', img = '" + article.getImg()
                + "', topic = " + article.getId() + ", summary = '" + article.getSummary()
                + "' WHERE id = " + article.getId();
        statement.executeUpdate(sqlStr);

        return true;
    }

    //
    public ArticleList searchArticle(int start, int recordNum, int topic) throws Exception {
        this.statement = connection.createStatement();
//        String sqlStr = "SELECT * FROM article limit "
//                + start + ", " + recordNum + " where topic=" + topic;

        String sqlStr = "SELECT * FROM article where topic=" + topic + " limit "
                + start + ", " + recordNum;
//        String sqlStr = "SELECT * FROM article where topic=" + topic;
        this.resultSet = statement.executeQuery(sqlStr);
        int id;
        int topicId;
        String title;
        String summary;
        String content;
        String img;

        while (resultSet.next()){
            id = resultSet.getInt("id");
            topicId = resultSet.getInt("topic");
            title = resultSet.getString("title");
            summary = resultSet.getString("summary");
            content = resultSet.getString("content");
            img = resultSet.getString("img");
            Article article = new Article(id, topicId, title, summary, content, img);
            articleList.addArticle(article);
        }

        return articleList;
    }


    public boolean login(String userName, String userPassword)throws Exception{
        PreparedStatement pstmt = connection.prepareStatement(
                "select * from user where userName=? and userPassword=?");
        pstmt.setString(1, userName);
        pstmt.setString(2, userPassword);
        resultSet = pstmt.executeQuery();

        boolean flag = false;
        if(resultSet.next()){
            flag = true;
        }

        return flag;
    }

    public int counter(String topic) throws Exception{
        PreparedStatement pstmt = connection.prepareStatement(
                "select count(*) from article where topic = ?");
        pstmt.setString(1, topic);
        resultSet = pstmt.executeQuery();

        int totalNum = 0;

        if(resultSet.next()){
            totalNum = resultSet.getInt(1);
        }

        return totalNum;
    }


    //
    public void Close() throws Exception {
        resultSet.close();
        statement.close();
        connection.close();
    }
}

