package com.example.albumslistapicall.Repo;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;




import java.util.List;


import javax.sql.DataSource;

import io.reactivex.Single;



public abstract class AlbumsRepository implements DataSource {



    private final DataSource remoteDataSource;

    private final DataSource localDataSource;



    public AlbumsRepository(DataSource remoteDataSource, DataSource localDataSource) {

        this.remoteDataSource = remoteDataSource;

        this.localDataSource = localDataSource;

    }



    @Override

    public Single<List<AlbumsResponseRepo>> getAlbumsResults() {
        return remoteDataSource.getAlbumsResults();
    }



    @Override

    public void addAlbums(AlbumsResponseRepo albumsResponseRepo) {
        localDataSource.addAlbums(albumsResponseRepo);

    }

}