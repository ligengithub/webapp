package com.example.webapp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.webapp.po.Result;
import com.example.webapp.po.UserInfo;
import com.example.webapp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * UserInfo 控制层
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Result<UserInfo> login(@RequestBody UserInfo userInfo) {

        UserInfo user = userInfoService.selectOne(new EntityWrapper<>(new UserInfo().setUsername(userInfo.getUsername())));

        if (user == null) {
            userInfoService.addUser(userInfo);
            return new Result("8001", "注册成功",userInfo);
        } else {
            if (StringUtils.pathEquals(user.getPassword(), userInfo.getPassword())) {
                return new Result("8001", "登录成功",user);
            } else {
                return new Result<>("4001", "登录失败，密码错误");
            }
        }
    }

}