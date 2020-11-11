package com.example.webapp.service;

import org.springframework.stereotype.Service;

import com.example.webapp.dao.IRequestHistoryMapper;
import com.example.webapp.po.RequestHistory;
import com.baomidou.framework.service.impl.ServiceImpl; 

/**
 *
 * RequestHistory 表数据服务层接口实现类
 *
 */
@Service
public class RequestHistoryService extends  ServiceImpl <IRequestHistoryMapper, RequestHistory>  {


}