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
    static int curPage = 1;
    static int pageSize = 3;
    static int lastPage = 0;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int count = UserDaoImpl.getCount();
        if((count%pageSize) == 0) {
            lastPage = count/pageSize;
        } else {
            lastPage = (count/pageSize) + 1;
        }
        request.setCharacterEncoding("utf-8");
        String typeChangePage = request.getParameter("changepage");
        if(typeChangePage.equals("首页")) {
            curPage = 1;
        } else if(typeChangePage.equals("上一页")) {
            if(curPage != 1) {
                curPage--;
            }
        } else if(typeChangePage.equals("下一页")) {
            if(curPage != lastPage) {
                curPage++;
            }
        } else if(typeChangePage.equals("尾页")) {
            curPage = lastPage;
        } else if(typeChangePage.equals("确定")) {
            int page = Integer.parseInt(request.getParameter("page"));
            if(page >= 1 && page <= lastPage) {
                curPage = page;
            }
        }
        response.sendRedirect("showUsers");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = new String(request.getRequestURI());
        if(uri.contains("show")) {
            UserDaoImpl userDao = new UserDaoImpl();
            List<User> userList = userDao.getUsers(curPage, pageSize);
            if(userList.size() != 0) {
                request.setAttribute("userlist", userList);
                System.out.println(curPage);
                request.setAttribute("curPage", curPage);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }
        }
    }
}
