package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Plan;
import com.hc.model.PlanStructure;
import com.hc.model.VideoResObj;

public class VideoMapper1 implements RowMapper {
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
		video.setTrainer_bio(rs.getString("bio"));
		video.setDuration_time(rs.getString("duration_time"));
		video.setCatId(rs.getString("catId"));
		video.setOnDemandId(rs.getString("onDemandId"));
		//video.setSubCatId(rs.getString("subCatId"));
		
		//goal.setPlanId(rs.getInt("planId"));
		return video;
	}

}
