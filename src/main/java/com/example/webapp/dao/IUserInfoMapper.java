package com.example.webapp.dao;

import com.example.webapp.domain.po.UserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * UserInfo 表数据库控制层接口
 */
public interface IUserInfoMapper extends BaseMapper<UserInfo> {


    int addUser(UserInfo userInfo);
}