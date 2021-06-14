package cn.edu.guet.dao.impl;

import cn.edu.guet.JDBC.OracleConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    Connection connection = OracleConnection.getConnection();
    @Override
    public List<User> getUsers() {
        Connection connection = OracleConnection.getConnection();
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM USERS";
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setUserid(resultSet.getString("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setAddress(resultSet.getString("address"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User getUser(String userid) {
        User user = new User();
        String sql = "SELECT * FROM USERS WHERE userid=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setUserid(resultSet.getString("userid"));
            user.setUsername(resultSet.getString("username"));
            user.setAddress(resultSet.getString("address"));
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

    public static void deleteUser(String userid) {
        Connection connection = OracleConnection.getConnection();
        String sql = "DELETE USERS WHERE userid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userid);
            int a = preparedStatement.executeUpdate();
            System.out.println("删除" + a + "条数据");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void updataUser(User user) {
        Connection connection = OracleConnection.getConnection();
        String sql = "UPDATE USERS SET username=?, address=? WHERE userid=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getAddress());
            preparedStatement.setString(3, user.getUserid());
            int a = preparedStatement.executeUpdate();
            System.out.println("修改" + a + "条数据");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void addUser(User user) {
        Connection connection = OracleConnection.getConnection();
        String sql = "INSERT INTO USERS VALUES(?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserid());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getAddress());
            int a = preparedStatement.executeUpdate();
            System.out.println("添加" + a + "条数据");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
