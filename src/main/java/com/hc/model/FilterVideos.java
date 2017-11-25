package com.hc.model;


import java.util.List;

public interface FilterVideos {
   public List<VideoResObj> meetCriteria(List<VideoResObj> persons,int input);
   public List<WeeklyWorkOut> meetCriteria1(List<WeeklyWorkOut> inputVideos,int input);
}