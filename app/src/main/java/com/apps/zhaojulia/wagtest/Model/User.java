package com.apps.zhaojulia.wagtest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Created by Julia on 8/5/17.
 * We expect from you to display at least username, badges and gravatar for every user.
 */

public class User {

    @SerializedName("display_name")
    String username; // display_name

    @SerializedName("badge_counts")
    HashMap<String, Integer> badgeCounts; // badge_counts

    @SerializedName("profile_image")
    String gravaterUrl; // profile_image

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, Integer> getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(HashMap<String, Integer> badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public String getGravaterUrl() {
        return gravaterUrl;
    }

    public void setGravaterUrl(String gravaterUrl) {
        this.gravaterUrl = gravaterUrl;
    }
}
