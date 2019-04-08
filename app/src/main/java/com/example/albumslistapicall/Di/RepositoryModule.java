package com.example.albumslistapicall.Di;

import com.example.albumslistapicall.Repo.AlbumsRepository;
import com.example.albumslistapicall.dao.LocalDataSource;
;



import javax.inject.Singleton;
import javax.sql.DataSource;


import dagger.Module;
import dagger.Provides;



@Module
public class RepositoryModule {



    @Provides
    @Singleton
    @Repository
    public DataSource provideRepository(@Remote DataSource remoteDataSource) {

        return new AlbumsRepository(remoteDataSource, LocalDataSource);

    }

}