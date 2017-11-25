package com.hc.model;

public class DashBoardData {

	private String dataType; //year,month,week,day
	private DashBoardItem item;
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public DashBoardItem getItem() {
		return item;
	}
	public void setItem(DashBoardItem item) {
		this.item = item;
	}
	
	
}
