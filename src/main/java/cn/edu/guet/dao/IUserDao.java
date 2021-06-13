package cn.edu.guet.dao;

import cn.edu.guet.been.User;

import java.util.List;

public interface IUserDao {
    List<User> getUsers();
    User getUser(String userid);
}
