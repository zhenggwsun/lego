package com.zhangweinan.model.model;

/**
 * 年龄分布echarts
 * Created by Eric on 2019/5/6.
 */
public class UserAgeChartsModel {

    private int ltTwenty;

    private int TwentyToForty;

    private int FortyToSixty;

    private int gtSixty;

    public UserAgeChartsModel() {
    }

    public UserAgeChartsModel(int ltTwenty, int twentyToForty, int fortyToSixty, int gtSixty) {
        this.ltTwenty = ltTwenty;
        TwentyToForty = twentyToForty;
        FortyToSixty = fortyToSixty;
        this.gtSixty = gtSixty;
    }

    public int getLtTwenty() {
        return ltTwenty;
    }

    public void setLtTwenty(int ltTwenty) {
        this.ltTwenty = ltTwenty;
    }

    public int getTwentyToForty() {
        return TwentyToForty;
    }

    public void setTwentyToForty(int twentyToForty) {
        TwentyToForty = twentyToForty;
    }

    public int getFortyToSixty() {
        return FortyToSixty;
    }

    public void setFortyToSixty(int fortyToSixty) {
        FortyToSixty = fortyToSixty;
    }

    public int getGtSixty() {
        return gtSixty;
    }

    public void setGtSixty(int gtSixty) {
        this.gtSixty = gtSixty;
    }
}
