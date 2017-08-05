package com.apps.zhaojulia.wagtest.Model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Created by Julia on 8/5/17.
 * We expect from you to display at least username, badges and gravatar for every user.
 */

public class User {

    @SerializedName("display_name")
    private String username; // display_name

    @SerializedName("badge_counts")
    private HashMap<String, Integer> badgeCounts; // badge_counts

    @SerializedName("profile_image")
    private String gravaterUrl; // profile_image

    public enum Badge {
        BRONZE,
        SILVER,
        GOLD
    }


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

    /**
     * Gets the hashmap of badge counts then depending on the
     * parameter color, returns that mapped value
     * @param color badge type
     * @return string of quantity of badges
     */
    public String getBadgeCount(Enum<Badge> color) {
        HashMap<String, Integer> map = getBadgeCounts();
        int count = 0;

        if (map != null) {
            if (color == Badge.BRONZE) {
                if (map.containsKey("bronze")) {
                    count = map.get("bronze");
                }
            } else if (color == Badge.SILVER) {
                if (map.containsKey("silver")) {
                    count = map.get("silver");
                }
            }if (color == Badge.GOLD) {
                if (map.containsKey("gold")) {
                    count = map.get("gold");
                }
            }
        }
        else {
            Log.i("badge", "Badge map is null.");
        }

        return String.valueOf(count);
    }
}
