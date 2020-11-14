package com.example.webapp.service;

import com.baomidou.framework.service.impl.ServiceImpl;
import com.example.webapp.dao.IRequestHistoryMapper;
import com.example.webapp.po.RequestHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * RequestHistory 表数据服务层接口实现类
 */
@Service
public class RequestHistoryService extends ServiceImpl<IRequestHistoryMapper, RequestHistory> {


    @Autowired
    private IRequestHistoryMapper historyMapper;

    public HashMap<String, Integer> getRecordCount() {
        HashMap<String, Integer> result = new HashMap<>();
        result.put("today", historyMapper.getTodayRecord());
        result.put("month", historyMapper.getMonthRecord());
        result.put("total", historyMapper.getTotalRecord());
        return result;
    }
}