package com.bignerdranch.andriod.nasaapi.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "XJN4yGu3pT0BvK88qisEndmOHpDDvGiQWi9sQma1"

interface NasaApi {

    @GET("planetary/apod")
    suspend fun fetchAstronomyPictureOfTheDay(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: Int = 1,
        @Query("extras") extras: String = "url_s",
    ): NasaResponse
}