package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Plan;
import com.hc.model.PlanStructure;
import com.hc.model.VideoResObj;

public class VideoMapper implements RowMapper {
	
	String catId;
	public VideoMapper(String catId)
	{
		this.catId=catId;
	}
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		VideoResObj video = new VideoResObj();

		video.setVideoId(rs.getString("content_feed_id"));
		video.setTitle(rs.getString("title"));
		video.setImage_url(rs.getString("image_url"));
		video.setContent_url(rs.getString("content_url"));
		video.setContent_text(rs.getString("content_text"));
		video.setFeed_type(rs.getString("feed_type"));
		video.setComment_count(rs.getString("comment_count"));
		video.setEnergy_score(rs.getString("energy_score"));
		video.setRelax_score(rs.getString("relax_score"));
		video.setTrainer_image(rs.getString("pic"));
		video.setTrainer_name(rs.getString("name"));
		video.setDuration_time(rs.getString("duration_time"));
		video.setTrainer_bio(rs.getString("bio"));
		video.setSubCatId(rs.getString("catId"));
		
	/*	int catId=rs.getInt("catId");
		if(catId==96 || catId==97 || catId==98 || catId==99 || catId==100 || catId==101) catId=8;
		else if(catId==32 || catId==33 || catId==34 || catId==102) catId=7;
		else if(catId==63 || catId==64 || catId==65 || catId==66 || catId==67 || catId==68 || catId==69) catId=62;*/
		video.setCatId(catId);
		
		//goal.setPlanId(rs.getInt("planId"));
		return video;
	}

}
