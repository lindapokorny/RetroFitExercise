package com.example.lindapokorny.retrofitexercise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class DogBreedViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    public DogBreedViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.dog_breed_image_view);
    }
    public void bind(DogBreed dogBreed){
        imageView.setImageDrawable(dogBreed.getDogbreedImageView());
    }
}
