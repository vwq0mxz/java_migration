package com.example.dao;

import com.example.model.User;
import java.util.List;

public interface UserDAO {
    User create(User user);
    User read(Long id);
    List<User> readAll();
    User update(User user);
    boolean delete(Long id);
}