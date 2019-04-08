package com.example.albumslistapicall.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.albumslistapicall.Models.AlbumsResponseRepo;

import java.util.List;

import io.reactivex.Maybe;



@Dao
interface JSONDAO {



    @Query("SELECT * FROM albums")
    Maybe<List<AlbumsResponseRepo>> getAlbums();



    @Insert
    void addAlbum(AlbumsResponseRepo albumResponse);



    @Delete
    void deleteAlbum(AlbumsResponseRepo albumResponse);



    @Update
    void updateAlbum(AlbumsResponseRepo albumResponse);

}