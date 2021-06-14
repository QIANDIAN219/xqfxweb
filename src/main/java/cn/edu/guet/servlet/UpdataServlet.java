package cn.edu.guet.servlet;

import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("updata");
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        System.out.println(userid);
        System.out.println(username);
        System.out.println(address);
        User user = new User(userid, username, address);
        UserDaoImpl.updataUser(user);
        response.sendRedirect("showUsers");
    }
}
