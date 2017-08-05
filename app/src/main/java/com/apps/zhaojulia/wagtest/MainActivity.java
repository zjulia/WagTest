package com.apps.zhaojulia.wagtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private StackOverflowAPI stackoverflowAPI;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createStackoverflowAPI();
        stackoverflowAPI.getUsers().enqueue(usersCallback);
    }

    private void createStackoverflowAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StackOverflowAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        stackoverflowAPI = retrofit.create(StackOverflowAPI.class);
    }


    Callback<ListWrapper<User>> usersCallback = new Callback<ListWrapper<User>>() {
        @Override
        public void onResponse(Call<ListWrapper<User>> call, Response<ListWrapper<User>> response) {
            if (response.isSuccessful()) {
                ListWrapper<User> usersListWrapper = response.body();
                ArrayAdapter<User> arrayAdapter = new ArrayAdapter<User>(MainActivity.this,
                        android.R.layout.simple_spinner_dropdown_item, usersListWrapper.items);
                //questionsSpinner.setAdapter(arrayAdapter);
            } else {
                Log.d("UsersCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<User>> call, Throwable t) {
            t.printStackTrace();
        }
    };

}
