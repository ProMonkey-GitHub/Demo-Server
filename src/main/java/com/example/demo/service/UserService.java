package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    List<User> findAll();

    Page<User> findByPage(int page, int pageSize);

    Page<User> findByPageWithKeyword(int page, int pageSize, String keyword);

    List<User> findByKeyword(String keyword);

    void deleteById(Long id);
}
