package com.andre.apps.randomfacts.common.api

import io.ktor.client.*
import io.ktor.client.request.*

class FactsApiImpl(private val client: HttpClient) : FactsApi {

    override suspend fun getRandomFact(): FactResponse {
        return client.get {
            url {
                encodedPath = "/random.json?language=en"
            }
        }
    }
}