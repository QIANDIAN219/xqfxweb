package cn.edu.guet.dao.impl;

import cn.edu.guet.JDBC.MyConnection;
import cn.edu.guet.been.User;
import cn.edu.guet.dao.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {

    public static List<User> getUsers(int curPage, int pageSize) {
        Connection connection = MyConnection.getConnection();
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM USERS LIMIT ?, ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int startPage = (curPage-1) * pageSize;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, startPage);
            preparedStatement.setInt(2, pageSize);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
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
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public static User getUser(String userid) {
        Connection connection = MyConnection.getConnection();
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
        Connection connection = MyConnection.getConnection();
        String sql = "DELETE FROM USERS WHERE userid=?";
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
        Connection connection = MyConnection.getConnection();
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
        Connection connection = MyConnection.getConnection();
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

    public static List<User> checkUsers(User conditionUser) {
        java.sql.Connection connection = MyConnection.getConnection();
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM USERS WHERE";
        String[] condition = new String[3];
        int k = 0;
        if(conditionUser.getUserid().length() != 0) {
            sql = sql.concat(" userid=? AND");
            condition[k++] = conditionUser.getUserid();
        }
        if(conditionUser.getUsername().length() != 0) {
            sql = sql.concat(" username=? AND");
            condition[k++] = conditionUser.getUsername();
        }
        if(conditionUser.getAddress().length() != 0) {
            sql = sql.concat(" address=? AND");
            condition[k++] = conditionUser.getAddress();
        }
        if(sql.endsWith(" AND")) {
            sql = sql.substring(0, sql.lastIndexOf(" AND"));
        }
        System.out.println(sql);
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < condition.length; i++) {
                if(condition[i] != null) {
                    preparedStatement.setString(i+1, condition[i]);
                }
            }
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
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
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public static int getCount() {
        Connection connection = MyConnection.getConnection();
        String sql = "SELECT COUNT(*) FROM USERS";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return resultSet.getInt("COUNT(*)");
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
        return 0;
    }
}
