package com.bigguy.movie.moviebox.bean;

/**
 * @author shkstart
 * @create 2019-03-17 11:01
 */
public class Rating {
    private String average;
    private String max;
    private String min;

    // 收藏数
    private int stars;

    @Override
    public String toString() {
        return "Rating{" +
                "average=" + average +
                ", max=" + max +
                ", min=" + min +
                ", stars=" + stars +
                '}';
    }


    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
