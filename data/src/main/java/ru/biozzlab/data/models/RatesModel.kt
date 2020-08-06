package ru.biozzlab.data.models

data class RatesModel(
    val rates: Map<String, Double>,
    val base: String,
    val date: String
)