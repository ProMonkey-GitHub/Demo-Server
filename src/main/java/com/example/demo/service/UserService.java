package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    Long findIdByUserName(String userName);

    List<User> findAll();

    Page<User> findByPage(int page, int pageSize);

    Page<User> findByPageWithKeyWord(int page, int pageSize, String keyword);

    void deleteById(Long id);
}
