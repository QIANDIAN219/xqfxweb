package cn.edu.guet;

import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User("", "lisi", "南宁");
        List<User> userList = UserDaoImpl.checkUsers(user);
        System.out.println(userList.get(0).getUserid());
    }
}
