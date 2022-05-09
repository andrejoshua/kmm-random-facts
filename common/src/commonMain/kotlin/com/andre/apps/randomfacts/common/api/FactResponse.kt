package com.andre.apps.randomfacts.common.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FactResponse(
    @SerialName("text")
    val text: String
)
