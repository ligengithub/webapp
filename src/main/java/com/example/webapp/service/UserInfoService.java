package com.example.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.dao.IUserInfoMapper;
import com.example.webapp.domain.po.UserInfo;
import com.baomidou.framework.service.impl.ServiceImpl; 

/**
 *
 * UserInfo 表数据服务层接口实现类
 *
 */
@Service
public class UserInfoService extends  ServiceImpl <IUserInfoMapper, UserInfo>  {


    @Autowired
    private IUserInfoMapper userInfoMapper;

    /**
     *@ desc : 添加用户
     *@ params
     *@ return
     *@ date 2020/5/4
     *@ author ligen
     */
    public int addUser(UserInfo userInfo){
        return userInfoMapper.addUser(userInfo);
    }


}