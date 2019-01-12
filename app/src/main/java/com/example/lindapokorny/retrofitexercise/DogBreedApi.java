package com.example.lindapokorny.retrofitexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogBreedApi {
    String ENDPOINT_DOG_API = "https://dog.ceo/api/breed/hound/images";

    @GET(ENDPOINT_DOG_API)
    Call<DogBreed> getDog();
}
