package cn.edu.guet;

import cn.edu.guet.JDBC.MyConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.impl.UserDaoImpl;

public class test {
    public static void main(String[] args) {
        System.out.println((UserDaoImpl.getCount()%2) == 0);
    }
}
