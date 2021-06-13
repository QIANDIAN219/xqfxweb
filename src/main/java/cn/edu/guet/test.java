package cn.edu.guet;

import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUser("001");
    }
}
