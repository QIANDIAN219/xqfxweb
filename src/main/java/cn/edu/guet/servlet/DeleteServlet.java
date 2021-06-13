package cn.edu.guet.servlet;

import cn.edu.guet.JDBC.OracleConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = new String(request.getParameter("id"));
        System.out.println("2删除ID" + id);
        UserDaoImpl.deleteUser(id);
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.getUsers();
        request.setAttribute("userlist", userList);
        request.getRequestDispatcher("main.jsp").forward(request, response);
//        response.sendRedirect("main");
    }
}
