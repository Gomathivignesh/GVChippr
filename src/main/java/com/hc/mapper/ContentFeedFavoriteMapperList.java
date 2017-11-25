package com.hc.mapper;

import java.io.Serializable;
import java.util.List;



public class ContentFeedFavoriteMapperList implements Serializable {

	private static final long serialVersionUID = 1L;
	private String category;
	private Integer categoryOrderId;
	private List<ContentFeedFavoriteMapper> contentFeedList;


	public ContentFeedFavoriteMapperList() {

	}

	public ContentFeedFavoriteMapperList(String category, Integer categoryOrderId,
			List<ContentFeedFavoriteMapper> contentFeedList) {
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

	public List<ContentFeedFavoriteMapper> getContentFeedList() {
		return contentFeedList;
	}


	public void setContentFeedList(List<ContentFeedFavoriteMapper> contentFeedList) {
		this.contentFeedList = contentFeedList;
	}
}
