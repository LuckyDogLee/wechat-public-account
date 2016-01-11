package article;

import model.Article;
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
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "";
        String user = "";
        String password = "";
        MySQL mySQL = new MySQL(url, user, password);
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        boolean flag = false;
        try {
            mySQL.Connect();
            flag = mySQL.login(userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (flag){
            out.write("true");
        }else {
            out.write("false");
        }

        out.close();
    }
}
