package cn.edu.guet.servlet;

import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Student Username:" + username);
        System.out.println("Student Password:" + password);
        String uri = request.getRequestURI();
        if(uri.contains("student")) {
            System.out.println("学生登录");
            if(username.equals("test") && password.equals("123456")){
                System.out.println("登录成功");
                UserDaoImpl userDao = new UserDaoImpl();
                List<User> userList = userDao.getUsers(1, 3);
                request.setAttribute("userlist", userList);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        } else if(uri.contains("teacher")) {
            System.out.println("教师登录");
            if(username.equals("test2") && password.equals("123456")){
                System.out.println("登录成功");
                response.sendRedirect("showUsers");
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Student Username:" + request.getParameter("username"));
        System.out.println("Student Password:" + request.getParameter("password"));
    }
}
