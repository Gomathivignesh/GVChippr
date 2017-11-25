package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Category;
import com.hc.model.Plan;

public class PlanCatMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category plan = new Category();

		plan.setId(rs.getInt("id"));
		plan.setName(rs.getString("name"));
		plan.setImageURL(rs.getString("imageURL"));
		plan.setDescription(rs.getString("description"));
		return plan;
	}

}
