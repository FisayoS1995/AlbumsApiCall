package com.example.albumslistapicall.Di;

import android.app.Application;



import com.example.albumslistapicall.Net.AlbumsListService;

import com.example.albumslistapicall.Constants;

import com.example.albumslistapicall.dao.RemoteDataSource;
import com.example.albumslistapicall.Repo.DataSource;




import java.util.concurrent.TimeUnit;



import javax.inject.Singleton;



import dagger.Module;

import dagger.Provides;

import okhttp3.Cache;

import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.converter.gson.GsonConverterFactory;



@Module

public class NetworkModule {

    @Provides

    @Singleton

    public Cache provideCache(Application application) {

        return new Cache(application.getCacheDir(), Constants.CACHE_SIZE);

    }



    @Provides

    @Singleton

    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {

        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    }



    @Provides

    @Singleton

    public OkHttpClient provideOkHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {

        return new OkHttpClient.Builder()

                .addInterceptor(httpLoggingInterceptor)

                .readTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)

                .connectTimeout(Constants.API_TIMEOUT, TimeUnit.SECONDS)

                .cache(cache)

                .build();

    }



    @Provides

    @Singleton

    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {

        return new Retrofit.Builder()

                .baseUrl(Constants.BASE_URL)

                .client(okHttpClient)

                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

                .build();

    }

    @Provides
    @Singleton
    public AlbumsListService provideAlbumsListService(Retrofit retrofit) {

        return retrofit.create(AlbumsListService.class);

    }



    @Provides
    @Singleton
    @Remote
    public DataSource provideRemoteDataSource(AlbumsListService albumsListService) {
        return new RemoteDataSource(albumsListService);

    }

}