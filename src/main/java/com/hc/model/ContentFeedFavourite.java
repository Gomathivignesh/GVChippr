package com.hc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
public class ContentFeedFavourite implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer content_feed_type_id;
	private String user_email_id;
	private Date created_dttm;
	
	public ContentFeedFavourite() {

	}

	public ContentFeedFavourite(Integer id, Integer content_feed_type_id,
			String user_email_id, Date created_dttm) {
		super();
		this.id = id;
		this.content_feed_type_id = content_feed_type_id;
		this.user_email_id = user_email_id;
		this.created_dttm = created_dttm;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getContent_feed_type_id() {
		return content_feed_type_id;
	}


	public void setContent_feed_type_id(Integer content_feed_type_id) {
		this.content_feed_type_id = content_feed_type_id;
	}


	public String getUser_email_id() {
		return user_email_id;
	}


	public void setUser_email_id(String user_email_id) {
		this.user_email_id = user_email_id;
	}


	public Date getCreated_dttm() {
		return created_dttm;
	}


	public void setCreated_dttm(Date created_dttm) {
		this.created_dttm = created_dttm;
	}}
