package com.example.albumslistapicall.dao;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.example.albumslistapicall.Constants;
import com.example.albumslistapicall.Models.AlbumsResponseRepo;


@Database(entities = {AlbumsResponseRepo.class},version = Constants.DATABASE_VERSION)

abstract class JSONDatabase extends RoomDatabase {



    public abstract JSONDAO jsondao();



    @NonNull

    @Override

    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {

        return null;

    }



    @NonNull

    @Override

    protected InvalidationTracker createInvalidationTracker() {

        return null;

    }



    @Override

    public void clearAllTables() {



    }

}