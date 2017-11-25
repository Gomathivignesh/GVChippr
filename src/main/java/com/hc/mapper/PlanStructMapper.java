package com.hc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hc.model.Plan;
import com.hc.model.PlanStructure;

public class PlanStructMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PlanStructure plan = new PlanStructure();

		plan.setId(rs.getInt("id"));
		plan.setDay(rs.getInt("day"));
		plan.setFirstCatId(rs.getInt("FirstCatId"));
		plan.setSecondCatId(rs.getInt("SecondCatId"));
		plan.setThirdCatId(rs.getInt("ThirdCatId"));
		plan.setFirstCatCount(rs.getInt("FirstCatCount"));
		plan.setSecondCatCount(rs.getInt("SecondCatCount"));
		plan.setThirdCatCount(rs.getInt("ThirdCatCount"));
		plan.setFirstCatName(rs.getString("firstCatName"));
		plan.setSecondCatName(rs.getString("secondCatName"));
		plan.setThirdCatName(rs.getString("thirdCatName"));
		plan.setDay_desc(rs.getString("day_desc"));
		plan.setFirstApproxMin(rs.getInt("firstCatMinutes"));
		plan.setSecondApproxMin(rs.getInt("secondCatMinutes"));
		plan.setThirdApproxMin(rs.getInt("thirdCatMinutes"));
		//goal.setPlanId(rs.getInt("planId"));
		return plan;
	}

}
