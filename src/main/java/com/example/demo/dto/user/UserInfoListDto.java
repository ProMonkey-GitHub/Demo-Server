package com.example.demo.dto.user;

import com.example.demo.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserInfoListDto implements Serializable {
    private int total;

    private UserInfo[] users;

    public UserInfoListDto(List<User> userList, int total) {
        this.total = total;
        this.users = new UserInfo[userList.size()];
        for (int i = 0; i < userList.size(); i++) {
            UserInfo userInfo = new UserInfo(userList.get(i));
            users[i] = userInfo;
        }
    }
}
