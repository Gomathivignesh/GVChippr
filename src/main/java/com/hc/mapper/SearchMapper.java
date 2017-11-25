package com.hc.mapper;

import com.hc.model.SearchData;
import com.hc.model.WorkOutData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gomathivignesh on 18/7/17.
 */
public class SearchMapper implements RowMapper{
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SearchData data=new SearchData();
            data.setTitle(rs.getString("title"));
            data.setUrl(rs.getString("contentUrl"));
            data.setCommentCount(rs.getLong("commentCount"));
            data.setCommentLike(rs.getLong("commentLike"));
            data.setContentFeedId(rs.getLong("contentFeedId"));
            data.setContentText(rs.getString("contentText"));
            data.setContentUrl(rs.getString("imageUrl"));
            data.setDurationTime(rs.getString("durationTime"));
            data.setEnable(rs.getString("enable"));
            data.setEnergyScore(rs.getString("energyScore"));
            data.setFeedType(rs.getString("feedType"));
            data.setRelaxScore(rs.getLong("relaxScore"));
            data.setTrainerDesc(rs.getString("trainerDesc"));
            data.setTrainerImage(rs.getString("trainerImage"));
            data.setTrainerName(rs.getString("trainerName"));
            data.setCategory(rs.getString("Category"));
        return data;

    }

}
