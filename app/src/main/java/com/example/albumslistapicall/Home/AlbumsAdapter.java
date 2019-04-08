package com.example.albumslistapicall.Home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.albumslistapicall.R;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder> {

    List<String> dataset;

    @NonNull
    @Override
    public AlbumsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);

        return new AlbumsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsViewHolder albumsViewHolder, int i) {
        //here we need ton insert the viewholder class with the textview.settext call back 15:09

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class AlbumsViewHolder extends RecyclerView.ViewHolder {
        //this is where the textview goes

        public AlbumsViewHolder (View view) {
            super(view);
            // type the textview followed by then the findviewbyid based on the textview
        }
    }

    public AlbumsAdapter(List<String> dataset) {
        this.dataset = dataset;
    }
}
