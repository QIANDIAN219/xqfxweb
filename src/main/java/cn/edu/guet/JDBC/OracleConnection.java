package cn.edu.guet.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            String url = "jdbc:oracle:thin:@192.168.235.129:1521:orcl";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, "lzh", "lzh1234");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
