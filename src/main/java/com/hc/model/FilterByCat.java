package com.hc.model;

import java.util.ArrayList;
import java.util.List;

public class FilterByCat implements FilterVideos {
	@Override
	public List<VideoResObj> meetCriteria(List<VideoResObj> inputVideos,int input) {
		List<VideoResObj> catVideos = new ArrayList<VideoResObj>(); 
	    for (VideoResObj video : inputVideos) {
	       if(Integer.parseInt(video.getCatId())==input){
	    	   catVideos.add(video);
	       }
	    }
	    return catVideos;
	}

	@Override
	public List<WeeklyWorkOut> meetCriteria1(List<WeeklyWorkOut> inputVideos, int input) {
		List<WeeklyWorkOut> catVideos = new ArrayList<WeeklyWorkOut>(); 
	    for (WeeklyWorkOut video : inputVideos) {
	       if(video.getCatId()==input){
	    	   catVideos.add(video);
	       }
	    }
	    return catVideos;
	}
}
