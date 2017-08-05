package com.apps.zhaojulia.wagtest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 8/5/17.
 */

public interface StackOverflowAPI {

    public String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/users?site=stackoverflow")
    Call<ListWrapper<User>> getUsers();

}
