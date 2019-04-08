package com.example.albumslistapicall.dao;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;

import java.util.List;


import javax.sql.DataSource;

import io.reactivex.Single;



public abstract class LocalDataSource implements DataSource {



    private final JSONDatabase jsonDatabase;



    public LocalDataSource(JSONDatabase jsonDatabase) {

        this.jsonDatabase = jsonDatabase;

    }



    @Override

    public Single<List<AlbumsResponseRepo>> getAlbumSearchResults() {

        return null;

    }



    @Override
    public void addAlbum(AlbumsResponseRepo albumsResponse) {

        jsonDatabase.jsondao().addAlbum(albumsResponse);

    }

}