package com.hc.model;


import java.util.ArrayList;
import java.util.List;

public class FilterByDay implements FilterVideos {


@Override
public List<VideoResObj> meetCriteria(List<VideoResObj> inputVideos,int input) {
	List<VideoResObj> dayVideos = new ArrayList<VideoResObj>(); 
    for (VideoResObj video : inputVideos) {
       if(Integer.parseInt(video.getDay())==input){
    	   dayVideos.add(video);
       }
    }
    return dayVideos;
}
@Override
public List<WeeklyWorkOut> meetCriteria1(List<WeeklyWorkOut> inputVideos,int input) {
	List<WeeklyWorkOut> dayVideos = new ArrayList<WeeklyWorkOut>(); 
    for (WeeklyWorkOut video : inputVideos) {
       if(video.getDayId()==input){
    	   dayVideos.add(video);
       }
    }
    return dayVideos;
}

}