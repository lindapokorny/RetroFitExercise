package com.example.lindapokorny.retrofitexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL_DOG_CEO = "https://dog.ceo";
    final Retrofit retrofit = createRetrofit();


    private List<DogBreed> dogBreedList = new ArrayList<>();

    private ImageView dog;
    private RecyclerView mRecyclerView;
    private String dogbreedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dog = findViewById(R.id.dog_breed_image_view);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(new DogBreedAdapter(dogBreedList));
        mRecyclerView.setLayoutManager(new
                GridLayoutManager(this, 5));
    }


        @Override
        public void onResponse(Call<DogBreed> call, Response<DogBreed> response) {
                        DogBreed responseDog = response.body();
                        Log.d("woohoo", "onResponse: " + responseDog.getMessage());


                        // implementation 'com.squareup.picasso:picasso:2.71828'
                        Picasso.get()
                                .load(responseDog.getMessage())
                                    .into(dog);
                    }

                    @Override
                    public void onFailure(Call<DogBreed> call, Throwable t){
            Log.d("boohoo", "onFailure: " + t.getMessage());
        }

                    private Retrofit createRetrofit() {
                        return new Retrofit.Builder()
                                .baseUrl(BASE_URL_DOG_CEO)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
                    }
        }
