package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/test")
public class HomeController {
    @Resource
    private UserRepository userRepository;

    @PostMapping("/insert")
    public String insert(@RequestBody User user) {
        userRepository.save(user);
        return "接口调用成功！";
    }

    @GetMapping("/select")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
