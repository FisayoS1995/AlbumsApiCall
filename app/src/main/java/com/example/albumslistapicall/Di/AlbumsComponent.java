package com.example.albumslistapicall.Di;

import android.app.Application;

import com.example.albumslistapicall.Net.AlbumsApi;

import javax.inject.Singleton;
import javax.sql.DataSource;

import dagger.BindsInstance;
import dagger.Component;

@Component (modules = {AlbumModule.class, NetworkModule.class})

@Singleton
public interface AlbumsComponent {

    @Repository
    DataSource repository();



    @Component.Builder
    interface Builder {
        AlbumsComponent.Builder();

        @BindsInstance Builder
        application(Application application);

    }

}
