package com.example.albumslistapicall.Net;

import android.database.Observable;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Retrofit;

public class AlbumsListService {
    Gson gson;
    Retrofit retrofit;

    public AlbumsListService(Gson gson, Retrofit retrofit) {
        this.gson = gson;
        this.retrofit = retrofit;
    }
    public android.database.Observable<List<AlbumsResponseRepo>> getRepoFromRemote(){
        AlbumsApi albumsApi = retrofit.create(AlbumsApi.class);
        Observable<List<AlbumsResponseRepo>> observablerepo = albumsApi.getRepoFromResults();
return observablerepo;
    }
}
