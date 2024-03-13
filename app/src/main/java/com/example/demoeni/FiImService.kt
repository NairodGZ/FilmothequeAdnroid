package com.example.demoeni

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface FiImService {

    companion object
    {
        val BASE_URL = "http://127.0.0.1:3000";

        // L'utilitaire de conversion JSON <=> Object
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        // Retrofit
        val retrofit = Retrofit.Builder().
        addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build();

    }

    @GET("/films")
    suspend fun getFilms() : ResponseMetier<List<Film>>

    @GET("/film/{id}")
    suspend fun getFilmById(@Path("id") idFilm : Int) : ResponseMetier<Film>

    @POST("/film/create")
    suspend fun createFilm(@Body film : Film, @Header("Authorization") token: String) : ResponseMetier<Any>

    @POST("/film/update/{id}")
    suspend fun updateFilm(@Body film : Film, @Header("Authorization") token: String)

    @POST("film/delete/{id}")
    suspend fun deleteFilm(@Path("id") idFilm : Int, @Header("Authorization") token: String)

    object FilmApi
    {
        val retrofitService : FiImService by lazy { retrofit.create(FiImService::class.java) }
    }






}