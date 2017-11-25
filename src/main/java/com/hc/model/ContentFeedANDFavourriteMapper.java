package com.hc.model;

import java.io.Serializable;
import java.util.List;

import com.hc.vo.ContentFeedANDFavourriteVO;


public class ContentFeedANDFavourriteMapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private String category;
	private Integer categoryOrderId;
	private List<ContentFeedANDFavourriteVO> contentFeedList;
	
	public ContentFeedANDFavourriteMapper() {

	}

	public ContentFeedANDFavourriteMapper(String category, Integer categoryOrderId,
			List<ContentFeedANDFavourriteVO> contentFeedList) {
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

	public List<ContentFeedANDFavourriteVO> getContentFeedList() {
		return contentFeedList;
	}

	public void setContentFeedList(List<ContentFeedANDFavourriteVO> contentFeedList) {
		this.contentFeedList = contentFeedList;
	}

}
