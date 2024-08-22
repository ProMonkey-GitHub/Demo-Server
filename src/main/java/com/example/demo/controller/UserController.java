package com.example.demo.controller;

import com.example.demo.dto.user.UserInfoListDto;
import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("api/users")
public class UserController {
    @Resource
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/insert")
//    public String insert(@RequestBody User user) {
//        userRepository.save(user);
//        return "接口调用成功！";
//    }
//
//    @GetMapping("/select")
//    public List<User> findAll() {
//        return userRepository.findAll();
//    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {

        userService.saveUser(user);

    }

    @PostMapping("/edit")
    public void modify(@RequestBody User user) {

        userService.saveUser(user);

    }

    @PostMapping("/delete")
    public void delete(@RequestParam Long id) {

        userService.deleteById(id);

    }

    @GetMapping("/fetch")
    public Result getAllUser(@RequestParam("page")int page, @RequestParam("page_size")int page_size) {

        List<User> userList = userService.findByPage(page - 1, page_size).getContent();

        int total = userService.findAll().size();

        UserInfoListDto userInfoListDto = new UserInfoListDto(userList, total);

        return new Result(userInfoListDto);
    }

    @GetMapping("/select")
    public List<User> getUserByKeyword(@RequestParam("keyword")String keyword, @RequestParam("page")int page, @RequestParam("page_size")int page_size) {

        return userService.findByPageWithKeyWord(page - 1, page_size, keyword).getContent();

    }
}
