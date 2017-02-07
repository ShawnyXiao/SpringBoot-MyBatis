package com.shawn.repository;

import com.shawn.model.entity.User;

import java.util.List;

/**
 * @author Xiaoyue Xiao
 */
public interface UserRepository {

    User selectUserById(Long id);

    User selectUserByUsername(String username);

    List<User> selectAllUsers();

    Integer insertUser(User user);

    Integer updateUserOnPasswordById(User user);

    Integer deleteUserById(Long id);

}
