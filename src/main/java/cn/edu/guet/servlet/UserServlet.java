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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("showUsers");
        String uri = new String(request.getRequestURI());
        if(uri.contains("show")) {
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> userList = userDao.getUsers();
            request.setAttribute("userlist", userList);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
    }
}
