package com.example.albumslistapicall.Home;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;

import java.util.List;

import javax.sql.DataSource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeViewModel extends ViewModel {



    private final ObservableBoolean progressObservable;

    private final MutableLiveData<List<AlbumsResponseRepo>> albumObservable;

    private final DataSource albumRepository;

    private final CompositeDisposable compositeDisposable;



    public HomeViewModel(DataSource albumRepository) {

        this.albumRepository = albumRepository;

        progressObservable = new ObservableBoolean(false);

        albumObservable = new MutableLiveData<>();

        compositeDisposable = new CompositeDisposable();

    }

    public ObservableBoolean getProgressObservable(){

        return progressObservable;

    }



    public LiveData<List<AlbumsResponseRepo>> getAlbumObservable(){

        return albumObservable;

    }



    public void getAlbums(){

        compositeDisposable.add(albumRepository.getAlbumResults()

                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())

                .doOnSubscribe(disposable -> progressObservable.set(true))

                .doOnEvent((success, failure)->progressObservable.set(false))

                .subscribe(albumObservable::setValue));

    }



    @Override

    protected void onCleared() {

        super.onCleared();

        compositeDisposable.clear();

    }

}
