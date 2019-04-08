package com.example.albumslistapicall.Repo;


import com.example.albumslistapicall.Models.AlbumsResponseRepo;



import java.util.List;



import io.reactivex.Single;



public interface DataSource {

    Single<List<AlbumsResponseRepo>> getAlbumResults();

    void addAlbum(AlbumsResponseRepo albumsResponse);
}




