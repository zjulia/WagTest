package com.apps.zhaojulia.wagtest.Utils;

import com.apps.zhaojulia.wagtest.Model.User;
import com.apps.zhaojulia.wagtest.Utils.ListWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by admin on 8/5/17.
 */

public interface StackOverflowAPI {

    public String BASE_URL = "https://api.stackexchange.com";

    @GET("/2.2/users?site=stackoverflow")
    Call<ListWrapper<User>> getUsers();

}
