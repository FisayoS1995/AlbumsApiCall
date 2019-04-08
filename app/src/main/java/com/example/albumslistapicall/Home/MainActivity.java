package com.example.albumslistapicall.Home;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.albumslistapicall.Net.AlbumsListService;
import com.example.albumslistapicall.Models.AlbumsResponseRepo;
import com.example.albumslistapicall.R;
import com.example.albumslistapicall.Di.App;
import com.example.albumslistapicall.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {



    @Inject

    HomeViewModel homeViewModel;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActivityMainBinding binding =

                DataBindingUtil.setContentView(this, R.layout.activity_main);



        DaggerHomeComponent.builder()

                .appComponent(((MyApplication)getApplication()).getAppComponent())

                .homeModule(new HomeModule(this))

                .build()

                .inject(this);



        binding.setProgressVisibility(homeViewModel.getProgressObservable());

        AlbumsAdapter albumsAdapter = new AlbumsAdapter("");

        binding.rvAlbums.setLayoutManager(new LinearLayoutManager(this));

        binding.rvAlbums.setAdapter(albumsAdapter);



        homeViewModel.getAlbums();



    }

}