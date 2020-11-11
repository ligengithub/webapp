package com.example.webapp.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.IdType;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 *
 * 
 *
 */
@TableName("request_history")
public class RequestHistory implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Long id;

	/** 访问ip */
	private String ip;

	/** 时间 */
	@TableField(value = "gmt_create")
	private Date gmtCreate;


	public Long getId() {
		return this.id;
	}

	public RequestHistory setId(Long id) {
		this.id = id;
		return this;
	}

	public String getIp() {
		return this.ip;
	}

	public RequestHistory setIp(String ip) {
		this.ip = ip;
		return this;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public RequestHistory setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
		return this;
	}

}
