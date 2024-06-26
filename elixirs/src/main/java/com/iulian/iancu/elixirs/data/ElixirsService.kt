package com.iulian.iancu.elixirs.data

import com.iulian.iancu.elixirs.domain.Elixir
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ElixirsService {

    @GET("Elixirs")
    suspend fun getElixirs(): Response<List<Elixir>>

    companion object {
        var retrofitService: ElixirsService? = null
        fun getInstance(): ElixirsService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://wizard-world-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ElixirsService::class.java)
            }
            return retrofitService!!
        }
    }
}