package com.andre.apps.randomfacts.common.api

interface FactsApi {

    suspend fun getRandomFact(): FactResponse
}