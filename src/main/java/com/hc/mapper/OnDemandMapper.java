package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Category;
import com.hc.model.OnDemandContent;
import com.hc.model.Plan;

public class OnDemandMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		OnDemandContent plan = new OnDemandContent();

		plan.setId(rs.getInt("id"));
		plan.setScreenName(rs.getString("screen_name"));
		plan.setTitle(rs.getString("title"));
		plan.setDescription(rs.getString("description"));
		return plan;
	}

}
