package cn.edu.guet.servlet;

import cn.edu.guet.JDBC.OracleConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Student Username:" + username);
        System.out.println("Student Password:" + password);
        if(username.equals("test") && password.equals("123456")){
            System.out.println("登录成功");
//            response.sendRedirect("showUsers");
//            UserDaoImpl userDao = new UserDaoImpl();
//            List<User> userList = userDao.getUsers();
//            request.setAttribute("userlist", userList);
            request.getRequestDispatcher("showUsers").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        System.out.println("Student Username:" + request.getParameter("username"));
        System.out.println("Student Password:" + request.getParameter("password"));
    }
}
