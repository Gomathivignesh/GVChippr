package com.hc.model;

import java.util.List;

public class DashBoardItem {

	private String workOut;
	private String totalWorkOutTime;
	private List<WorkOutData> workOutdata;
	private List<ChartData> chartData;
	public String getWorkOut() {
		return workOut;
	}
	public void setWorkOut(String workOut) {
		this.workOut = workOut;
	}
	
	public List<WorkOutData> getWorkOutdata() {
		return workOutdata;
	}
	public void setWorkOutdata(List<WorkOutData> workOutdata) {
		this.workOutdata = workOutdata;
	}
	public List<ChartData> getChartData() {
		return chartData;
	}
	public void setChartData(List<ChartData> charData) {
		this.chartData = charData;
	}
	public String getTotalWorkOutTime() {
		return totalWorkOutTime;
	}
	public void setTotalWorkOutTime(String totalWorkOutTime) {
		this.totalWorkOutTime = totalWorkOutTime;
	}
	
}
