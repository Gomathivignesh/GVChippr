package com.hc.util;

import java.util.Comparator;

import com.hc.model.ChartData;

public class SortBasedOnDemand implements Comparator<ChartData> {
    @Override
    public int compare(ChartData o1, ChartData o2) {
        return o1.getIsOnDemand() -o2.getIsOnDemand();
    }
}