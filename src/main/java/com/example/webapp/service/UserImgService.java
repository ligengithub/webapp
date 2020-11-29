package com.example.webapp.service;

import org.springframework.stereotype.Service;

import com.example.webapp.dao.IUserImgMapper;
import com.example.webapp.domain.po.UserImg;
import com.baomidou.framework.service.impl.ServiceImpl; 

/**
 *
 * UserImg 表数据服务层接口实现类
 *
 */
@Service
public class UserImgService extends  ServiceImpl <IUserImgMapper, UserImg>  {


}