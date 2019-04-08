package com.example.albumslistapicall.dao;


import com.example.albumslistapicall.Constants;
import com.example.albumslistapicall.Models.AlbumsResponseRepo;
import com.example.albumslistapicall.Net.AlbumsListService;

import java.util.List;

import javax.sql.DataSource;

import io.reactivex.Single;

public abstract class RemoteDataSource implements DataSource {



    private final AlbumsListService albumsListService;



    public RemoteDataSource(AlbumsListService albumsListService) {

        this.albumsListService = albumsListService;

    }





    @Override

    public Single<List<AlbumsResponseRepo>> getAlbumSearchResults() {

        return albumsListService.getAlbumsApi(

                Constants.ENDPOINT

        );

    }



    @Override

    public void addAlbum(AlbumsResponseRepo albumsResponse) {

    }

}