package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.WeeklyWorkOut;

public class WeeklyWorkOutMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		WeeklyWorkOut workOut =new WeeklyWorkOut();
		workOut.setWorkOutId(rs.getString("id"));
		workOut.setWeekNumber(rs.getInt("weekNumber"));
		workOut.setVideoId(rs.getInt("videoId"));
		workOut.setUserId(rs.getInt("userId"));
		workOut.setWatchedTime(rs.getString("watchedTime"));
		workOut.setIsWatched(rs.getInt("done"));
		workOut.setDayId(rs.getInt("dayId"));
		workOut.setCatId(rs.getInt("catId"));
		workOut.setPlanId(rs.getInt("planId"));
		
		workOut.setTitle(rs.getString("title"));
		workOut.setImage_url(rs.getString("image_url"));
		workOut.setContent_url(rs.getString("content_url"));
		workOut.setContent_text(rs.getString("content_text"));
		workOut.setFeed_type(rs.getString("feed_type"));
		workOut.setComment_count(rs.getString("comment_count"));
		workOut.setEnergy_score(rs.getString("energy_score"));
		workOut.setRelax_score(rs.getString("relax_score"));
		workOut.setTrainer_image(rs.getString("pic"));
		workOut.setTrainer_name(rs.getString("name"));
		workOut.setTrainerBio(rs.getString("bio"));
		workOut.setDuration_time(rs.getString("duration_time"));
		
		workOut.setLastUpdated(rs.getString("lastUpdated"));
		workOut.setCreated(rs.getString("created"));
		workOut.setPlanName(rs.getString("planName"));
		workOut.setBtm_code(rs.getString("btm_code"));
		workOut.setBt_status(rs.getString("bt_status"));
		if(workOut.getCatId()==61 || workOut.getCatId()==62)
		{
			workOut.setAudioUrl(rs.getString("audioUrl"));	
		}
		
		
		return workOut;
	}

}
