package com.hc.model;

import java.io.Serializable;
import java.util.List;

import com.hc.vo.ContentFeedVO;


public class ContentFeedMapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private String category;
	private Integer categoryOrderId;
	private List<ContentFeedVO> contentFeedList;
	
	
	public ContentFeedMapper() {

	}

	public ContentFeedMapper(String category, Integer categoryOrderId,
			List<ContentFeedVO> contentFeedList) {
		super();
		this.category = category;
		this.categoryOrderId = categoryOrderId;
		this.contentFeedList = contentFeedList;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Integer getCategoryOrderId() {
		return categoryOrderId;
	}

	public void setCategoryOrderId(Integer categoryOrderId) {
		this.categoryOrderId = categoryOrderId;
	}

	public List<ContentFeedVO> getContentFeedList() {
		return contentFeedList;
	}


	public void setContentFeedList(List<ContentFeedVO> contentFeedList) {
		this.contentFeedList = contentFeedList;
	}
}
