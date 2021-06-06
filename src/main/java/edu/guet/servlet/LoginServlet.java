package edu.guet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
        System.out.println("Student Username:" + request.getParameter("username"));
        System.out.println("Student Password:" + request.getParameter("password"));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET");
        System.out.println("Student Username:" + request.getParameter("username"));
        System.out.println("Student Password:" + request.getParameter("password"));
    }
}
