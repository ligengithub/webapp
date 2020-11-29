package com.example.webapp.dao;

import com.example.webapp.domain.po.RequestHistory;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * RequestHistory 表数据库控制层接口
 */
@Component
public interface IRequestHistoryMapper extends BaseMapper<RequestHistory> {

    Integer getTodayRecord();

    Integer getMonthRecord();

    Integer getTotalRecord();

}