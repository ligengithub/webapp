package com.example.webapp.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.webapp.exception.MyException;
import com.example.webapp.response.Response;
import com.example.webapp.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webapp.dao.IUserInfoMapper;
import com.example.webapp.domain.po.UserInfo;
import com.baomidou.framework.service.impl.ServiceImpl;
import org.springframework.util.StringUtils;

/**
 * UserInfo 表数据服务层接口实现类
 */
@Service
public class UserInfoService extends ServiceImpl<IUserInfoMapper, UserInfo> {


    @Autowired
    private IUserInfoMapper userInfoMapper;

    /**
     * @ desc : 添加用户
     * @ params
     * @ return
     * @ date 2020/5/4
     * @ author ligen
     */
    public int addUser(UserInfo userInfo) {
        return userInfoMapper.addUser(userInfo);
    }


    public boolean login(LoginVo userInfo) throws MyException {
        UserInfo user = this.selectOne(new EntityWrapper<>(new UserInfo().setUsername(userInfo.getUsername())));
        if (user == null) {
            this.addUser(new UserInfo().setUsername(userInfo.getUsername()).setPassword(userInfo.getPassword()));
            return true;
        } else {
            if (StringUtils.pathEquals(user.getPassword(), userInfo.getPassword())) {
                return true;
            } else {
                throw new MyException(MyException.CODE_AUTH_ERROR);
            }
        }
    }
}