package com.alexander.countryapp

data class Country(
    val name:String,
    val capital: String,
    val population: Long,
    val area: Long,
    val languages: List<Language>
)
