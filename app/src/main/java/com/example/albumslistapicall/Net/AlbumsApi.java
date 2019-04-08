package com.example.albumslistapicall.Net;

import android.database.Observable;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;

import java.util.List;

import retrofit2.http.GET;

public interface AlbumsApi {
    @GET("albums")
    Observable<List<AlbumsResponseRepo>> getRepoFromResults();
}
