package com.iulian.iancu.elixirs.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Elixir (
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("effect")
    val effect: String?,
    @Expose
    @SerializedName("sideEffects")
    val sideEffects: String?,
    @Expose
    @SerializedName("characteristics")
    val characteristics: String?,
    @Expose
    @SerializedName("time")
    val time: String?,
    @Expose
    @SerializedName("difficulty")
    val difficulty: String?,
    @Expose
    @SerializedName("ingredients")
    val ingredients: List<Ingredients>
)

data class Ingredients(
    @Expose
    @SerializedName("name")
    val name: String
)