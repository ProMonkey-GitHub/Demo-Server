package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Long findIdByUserName(String userName) {
        return userRepository.findIdByUserName(userName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> findByPage(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findByPageWithKeyWord(int page, int pageSize, String keyword) {
        Pageable pageable = PageRequest.of(page, pageSize);
        //自定义查询条件
        Specification<User> spec = (root, query, criteriaBuilder) -> {
            //根据属性名获取查询对象的属性
            Path<Object> id = root.get("id");
            Path<Object> userName = root.get("userName");
//            Path<Object> email = root.get("email");

            Predicate likeId = criteriaBuilder.like(id.as(String.class), "%" + keyword + "%");
            Predicate likeUserName = criteriaBuilder.like(userName.as(String.class), "%" + keyword + "%");
//            Predicate likeEmail = criteriaBuilder.like(email.as(String.class), "%" + keyword + "%");
//            return criteriaBuilder.or(likeId, likeUserName, likeEmail);
            return criteriaBuilder.or(likeId, likeUserName);
        };
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
