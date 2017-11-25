package com.hc.util;

import java.util.Comparator;

import com.hc.model.VideoResObj;

public class SortVideos implements Comparator<VideoResObj> {
    @Override
    public int compare(VideoResObj o1, VideoResObj o2) {
        return Integer.parseInt(o1.getDay()) - (Integer.parseInt(o2.getDay()));
    }
}