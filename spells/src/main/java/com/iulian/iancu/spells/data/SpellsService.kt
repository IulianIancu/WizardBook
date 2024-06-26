package com.iulian.iancu.spells.data

import com.iulian.iancu.spells.domain.Spell
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SpellsService {

    @GET("Spells")
    suspend fun getSpells(): Response<List<Spell>>

    companion object {
        var retrofitService: SpellsService? = null
        fun getInstance(): SpellsService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://wizard-world-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(SpellsService::class.java)
            }
            return retrofitService!!
        }
    }
}