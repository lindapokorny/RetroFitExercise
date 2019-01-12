package com.example.lindapokorny.retrofitexercise;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class DogBreedAdapter extends RecyclerView.Adapter<DogBreedViewHolder> {
    private List<DogBreed> dogBreedList;

    public  DogBreedAdapter(List <DogBreed> dogBreedList){
        this.dogBreedList = dogBreedList;
    }
    @NonNull
    @Override
    public DogBreedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_tile, viewGroup, false);
        return new DogBreedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogBreedViewHolder dogBreedViewHolder, int i) {
        dogBreedViewHolder.bind(dogBreedList.get(i));

    }

    @Override
    public int getItemCount() {
        return dogBreedList.size();
    }
}
