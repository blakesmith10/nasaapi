package com.bignerdranch.andriod.nasaapi

import com.bignerdranch.andriod.nasaapi.api.GalleryItem
import com.bignerdranch.andriod.nasaapi.api.NasaApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class PhotoRepository {

    private val nasaApi: NasaApi

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        nasaApi = retrofit.create()
    }

    suspend fun fetchPhotos(): List<GalleryItem> = nasaApi.fetchAstronomyPictureOfTheDay().photos.galleryItems

}

