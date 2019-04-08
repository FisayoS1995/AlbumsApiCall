package com.example.albumslistapicall.Models;



import android.arch.persistence.room.Entity;

import android.arch.persistence.room.PrimaryKey;



import com.example.albumslistapicall.Constants;

import com.google.gson.annotations.Expose;

import com.google.gson.annotations.SerializedName;



@Entity(tableName = Constants.TABLE_NAME)

public class AlbumsResponseRepo {



    @PrimaryKey(autoGenerate = true)

    @SerializedName("userId")

    @Expose

    private Integer userId;

    @SerializedName("id")

    @Expose

    private Integer id;

    @SerializedName("title")

    @Expose

    private String title;



    public Integer getUserId() {

        return userId;

    }



    public void setUserId(Integer userId) {

        this.userId = userId;

    }



    public Integer getId() {

        return id;

    }



    public void setId(Integer id) {

        this.id = id;

    }



    public String getTitle() {

        return title;

    }



    public void setTitle(String title) {

        this.title = title;

    }



}