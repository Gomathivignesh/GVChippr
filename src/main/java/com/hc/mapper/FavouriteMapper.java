package com.hc.mapper;

import com.hc.model.FavouritesData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gomathivignesh on 19/7/17.
 */
public class FavouriteMapper implements RowMapper {
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            FavouritesData data=new FavouritesData();
            data.setTitle(rs.getString("title"));
            data.setImageURL(rs.getString("imageURL"));
            data.setTrainerName(rs.getString("trainerName"));
            data.setVideoURL(rs.getString("contentURL"));
        return data;

        }
}
