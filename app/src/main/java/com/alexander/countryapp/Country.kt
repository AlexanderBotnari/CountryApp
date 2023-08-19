package com.alexander.countryapp

import com.google.gson.JsonObject
import kotlin.jvm.internal.MagicApiIntrinsics

data class Country(
    val name: String,
    val capital: String,
    val population: Long,
    val area: Long,
    val languages: List<Language>,
    val flag:String
)
