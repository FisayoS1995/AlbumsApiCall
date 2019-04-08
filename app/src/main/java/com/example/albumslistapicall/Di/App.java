package com.example.albumslistapicall.Di;

import android.app.Application;

import com.example.albumslistapicall.Net.AlbumsListService;
import com.google.gson.Gson;

import retrofit2.Retrofit;

public class App extends Application {
    AlbumsListService albumsListService;

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
    }

    public AlbumsListService albumsListService(Gson gson, Retrofit retrofit) {
        return appComponent.getAlbumsListService();
    }



    public AppComponent getAppComponent() {
        return appComponent;
    }
}

