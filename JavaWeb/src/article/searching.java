package article;

import model.Article;
import model.ArticleList;
import model.MySQL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jack Lee on 2016/1/4.
 */
public class searching extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";
        String user = "";
        String password = "";
        Article article;
        String content = "";
        String strCounter = request.getParameter("counter");
        String strRecordNum = request.getParameter("recordNum");
        String strTopic = request.getParameter("topic");

        int counter = Integer.parseInt(strCounter);
        int recordNum = Integer.parseInt(strRecordNum);
        int topic = Integer.parseInt(strTopic);

        int start = (counter-1)*recordNum;

        int totalNum = 0;

        MySQL mySQL = new MySQL(url, user, password);
        try {
            mySQL.Connect();
            totalNum = mySQL.counter(strTopic);
            System.out.println(totalNum);
            ArticleList articleList = mySQL.searchArticle(start, recordNum, topic);
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();

            for (int i = 0; i < recordNum; i++){
                try {
                    article = articleList.searchArticle(i);
                    JSONObject jsonArticle = new JSONObject();
                    jsonArticle.put("id", article.getId());
                    jsonArticle.put("topic", article.getTopic());
                    jsonArticle.put("title", article.getTitle());
                    jsonArticle.put("summary", article.getSummary());
                    jsonArticle.put("content", article.getContent());
                    jsonArticle.put("imgUrl", article.getImg());
                    jsonArray.put(jsonArticle);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            jsonObject.put("articles", jsonArray);
            content = jsonObject.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(content);
        out.close();

        try {
            mySQL.Close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
