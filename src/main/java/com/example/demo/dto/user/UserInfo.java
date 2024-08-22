package com.example.demo.dto.user;

import com.example.demo.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
public class UserInfo implements Serializable {
    private long uid;
    private String name;

    private char gender;
    private String role;
    private Date birthday;

    public UserInfo(User user) {
        this.uid = user.getId();
        this.name = user.getUserName();
        this.gender = user.getGender();
        this.role = user.getRole();
        this.birthday = user.getBirthday();
    }
}
