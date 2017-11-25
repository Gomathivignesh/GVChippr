package com.hc.util;

import java.util.Comparator;

import com.hc.model.WeeklyWorkOut;

public class SortVideos1 implements Comparator<WeeklyWorkOut> {
    @Override
    public int compare(WeeklyWorkOut o1, WeeklyWorkOut o2) {
        return o1.getDayId() - o2.getDayId();
    }
}