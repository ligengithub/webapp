package com.example.webapp.domain.po;

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
@TableName("user_img")
public class UserImg implements Serializable {

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	/**  */
	@TableId(type = IdType.AUTO)
	private Integer id;

	/**  */
	@TableField(value = "user_id")
	private Integer userId;

	/** 图片访问路径 */
	@TableField(value = "image_url")
	private String imageUrl;

	/** qiniu 的图片唯一标识别 */
	@TableField(value = "img_uid")
	private String imgUid;

	/** 图片名字 */
	@TableField(value = "img_name")
	private String imgName;

	/**  */
	@TableField(value = "gmt_create")
	private Date gmtCreate;

	/**  */
	@TableField(value = "gmt_modify")
	private Date gmtModify;


	public Integer getId() {
		return this.id;
	}

	public UserImg setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public UserImg setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public UserImg setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
		return this;
	}

	public String getImgUid() {
		return this.imgUid;
	}

	public UserImg setImgUid(String imgUid) {
		this.imgUid = imgUid;
		return this;
	}

	public String getImgName() {
		return this.imgName;
	}

	public UserImg setImgName(String imgName) {
		this.imgName = imgName;
		return this;
	}

	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	public UserImg setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
		return this;
	}

	public Date getGmtModify() {
		return this.gmtModify;
	}

	public UserImg setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
		return this;
	}

}
