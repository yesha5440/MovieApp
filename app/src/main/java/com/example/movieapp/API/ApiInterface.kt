package com.example.movieapp.API

import android.telecom.Call
import com.example.movieapp.Model.UpcomingMovieModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("upcoming")
    fun getUpcomingMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("popular")
    fun getPopularMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("now playing")
    fun getNowplayingMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

    @GET("top rated")
    fun getTopMovies(
        @Query("page") page: Int
    ) :Call<UpcomingMovieModel>

}