package com.quangpao.webservice2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView superRecyclerView;
    ArrayList<Post> postArrayList;
    PostRVAdapter postRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getPosts();
    }

    private void getPosts() {
        Call<List<Post>> call = RetrofitClient.getInstance().getMyApi().getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                if (!posts.isEmpty()) {
                    postArrayList = new ArrayList<>(posts);
                } else {
                    postArrayList = new ArrayList<>();
                }

                setContentView(R.layout.activity_main);

                superRecyclerView = findViewById(R.id.rvPosts);
                postRVAdapter = new PostRVAdapter(postArrayList, getApplicationContext());
                superRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
                superRecyclerView.setAdapter(postRVAdapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_SHORT).show();
            }
        });
    }
}