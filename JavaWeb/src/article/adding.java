package article;

import model.Article;
import model.MySQL;
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
public class adding extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";
        String user = "";
        String password = "";
        MySQL mySQL = new MySQL(url, user, password);
        Article article = new Article();
        String jsonStr = request.getParameter("jsonStr");

        try {
            JSONObject jsonObj= new JSONObject(jsonStr);

            String strTopic = (String) jsonObj.get("topic");
            String title = (String) jsonObj.get("title");
            String summary = (String) jsonObj.get("summary");
            String content = (String) jsonObj.get("content");
            String img = (String) jsonObj.get("imgUrl");
            int topic = Integer.parseInt(strTopic);

            article.setTopic(topic);
            article.setTitle(title);
            article.setSummary(summary);
            article.setContent(content);
            article.setImg(img);

            mySQL.Connect();
            mySQL.addArticle(article);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("successfulAdding!");
        out.close();

//        try {
//            mySQL.Close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}