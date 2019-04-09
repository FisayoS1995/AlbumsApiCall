package com.example.albumslistapicall.Di;

import android.app.Application;

import com.example.albumslistapicall.Net.AlbumsListService;
import com.google.gson.Gson;

import retrofit2.Retrofit;

public class App extends Application {
    AlbumsListService albumsListService;

    App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AlbumsListService albumsListService(Gson gson, Retrofit retrofit) {
        return app.getAlbumsListService();
    }




    public App getApp() {
        return app;
    }
}

