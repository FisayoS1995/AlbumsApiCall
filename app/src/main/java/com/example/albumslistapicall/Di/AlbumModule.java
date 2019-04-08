package com.example.albumslistapicall.Di;

import com.example.albumslistapicall.Net.AlbumsListService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AlbumModule {

    @Provides
    Gson providesGson() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }


    @Provides
    AlbumsListService provideAlbumsListService(Gson gson, Retrofit retrofit){
        AlbumsListService albumsListService = new AlbumsListService(gson, retrofit);
                return albumsListService;
    }
}
