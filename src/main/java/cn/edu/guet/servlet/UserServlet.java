package cn.edu.guet.servlet;

import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        if(username.equals("test") && password.equals("123456")){
//            System.out.println("登录成功");
//            UserDaoImpl userDao = new UserDaoImpl();
//            List<User> userList = userDao.getUsers();
//            request.setAttribute("userlist", userList);
//            request.getRequestDispatcher("main.jsp").forward(request, response);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        String uri = new String(request.getRequestURI());
//        String userid = new String(request.getParameter("id"));
        if(uri.contains("show")) {
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> userList = userDao.getUsers();
            request.setAttribute("userlist", userList);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
    }
}
