package com.microservices.moviecatalogservice.bean;

import java.util.List;

public class UserRatings {
    private String userId;
    private List<Rating> userRatings;

    public UserRatings() {
    }

    public UserRatings(String userId, List<Rating> userRatings) {
        this.userId = userId;
        this.userRatings = userRatings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<Rating> userRatings) {
        this.userRatings = userRatings;
    }

    @Override
    public String toString() {
        return "UserRatings{" +
                "userId=" + userId +
                ", userRatings=" + userRatings +
                '}';
    }
}
