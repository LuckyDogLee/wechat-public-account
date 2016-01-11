package article;

import model.MySQL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Jack Lee on 2016/1/4.
 */
public class removing extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";
        String user = "";
        String password = "";
        MySQL mySQL = new MySQL(url, user, password);
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        try {
            mySQL.Connect();
            mySQL.removeArticle(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("successfulRemoving!");
        out.close();

//        try {
//            mySQL.Close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}


