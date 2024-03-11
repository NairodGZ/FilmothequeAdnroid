package com.example.demoeni

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface PersonneService {

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

    @GET("/persons")
    suspend fun getPersonnes() : List<Personne>

    object PersonApi
    {
        val retrofitService : PersonneService by lazy { retrofit.create(PersonneService::class.java) }
    }

}