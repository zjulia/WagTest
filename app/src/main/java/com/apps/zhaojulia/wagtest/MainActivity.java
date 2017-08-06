package com.apps.zhaojulia.wagtest;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.apps.zhaojulia.wagtest.Model.User;
import com.apps.zhaojulia.wagtest.Utils.ListWrapper;
import com.apps.zhaojulia.wagtest.Utils.StackOverflowAPI;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * X You will need to connect to Stackoverflow Users API Endpoint and retrieve the first page of data. FULL API documentation
 * X Display the retrieved data through a TableLayout.
 * X We expect from you to display at least username, badges and gravatar for every user.
 * X While the gravatar is being downloaded, the UI should show a loading animation.
 * X (Glide auto) Each of the photos should be downloaded only once and stored for offline usage.
 * X The UI should always be responsive.
 */
public class MainActivity extends AppCompatActivity {

    private StackOverflowAPI stackoverflowAPI;
    private TableLayout usersTableLayout;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersTableLayout = (TableLayout) findViewById(R.id.table_layout);

        createStackOverflowAPI();
        stackoverflowAPI.getUsers().enqueue(usersCallback);
    }

    /**
     * Sets up api
     */
    private void createStackOverflowAPI() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StackOverflowAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        stackoverflowAPI = retrofit.create(StackOverflowAPI.class);
    }


    /**
     * Handles callback, the users are obtained in the list wrapper and then displayed
     * using a helper method
     */
    Callback<ListWrapper<User>> usersCallback = new Callback<ListWrapper<User>>() {
        @Override
        public void onResponse(Call<ListWrapper<User>> call, Response<ListWrapper<User>> response) {
            if (response.isSuccessful()) {
                ListWrapper<User> usersListWrapper = response.body();
                displayUsers(usersListWrapper.getItems());
                removeLoadingIcon();
            } else {
                Log.d("UsersCallback", "Code: " + response.code() + " Message: " + response.message());
            }
        }

        @Override
        public void onFailure(Call<ListWrapper<User>> call, Throwable t) {
            t.printStackTrace();
        }
    };

    private void removeLoadingIcon() {
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }

    /**
     * Inflates the table row view and populates accordingly
     * @param users list of users
     */
    private void displayUsers(List<User> users) {
        for (User user : users) {
            // Inflate
            TableRow inflateRow = (TableRow) View.inflate(MainActivity.this, R.layout.table_row, null);

            // Update picture
            ImageView profilePic = (ImageView) inflateRow.findViewById(R.id.profile_picture);
            Glide.with(this)
                    .load(user.getGravaterUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(profilePic);

            // Update username
            TextView textview = (TextView) inflateRow.findViewById(R.id.username_box);
            textview.setText(user.getUsername());

            // Update badges
            TextView bronze = (TextView) inflateRow.findViewById(R.id.bronze_badges);
            bronze.setText(user.getBadgeCount(User.Badge.BRONZE));
            TextView silver = (TextView) inflateRow.findViewById(R.id.silver_badges);
            silver.setText(user.getBadgeCount(User.Badge.SILVER));
            TextView gold = (TextView) inflateRow.findViewById(R.id.gold_badges);
            gold.setText(user.getBadgeCount(User.Badge.GOLD));

            // Attach to main table layout
            usersTableLayout.addView(inflateRow);
        }
    }

}
