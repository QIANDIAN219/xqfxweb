package cn.edu.guet.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static java.sql.Connection getConnection(){
        java.sql.Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=gbk";
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
//            String url = "jdbc:oracle:thin:@192.168.235.129:1521:orcl";
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, "root", "lzh1234");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
