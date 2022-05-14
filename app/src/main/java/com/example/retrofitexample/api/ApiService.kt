package com.example.retrofitexample.api

import com.example.retrofitexample.model.ITunesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // https://itunes.apple.com/search?term=pop&amp;media=music&entity=song&limit=5
    // NOTICE: you need to use &amp; after the term=<query> BUT NOT for other query terms

    @GET("search?term=country&amp;media=music&entity=song&limit=50")
    fun getSongs(
    ): Call<ITunesResponse>

    companion object {
        private var instance: Retrofit? = null

        fun createRetrofit(): Retrofit {
            if (instance == null) {
                instance =
                    Retrofit.Builder()
                        .baseUrl("https://itunes.apple.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }

            return instance!! // !! -> this will NOT be null here
        }
    }
}