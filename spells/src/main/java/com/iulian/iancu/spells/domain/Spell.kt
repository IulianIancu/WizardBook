package com.iulian.iancu.spells.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Spell(
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("incantation")
    val incantation: String?,
    @Expose
    @SerializedName("effect")
    val effect: String?,
    @Expose
    @SerializedName("canBeVerbal")
    val canBeVerbal: Boolean,
    @Expose
    @SerializedName("type")
    val type: String?,
    @Expose
    @SerializedName("light")
    val light: String?
)