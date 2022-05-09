package com.andre.apps.randomfacts.common.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<out T>(
    @SerialName("success")
    val success: Map<String, String>,
    @SerialName("contents")
    val contents: T
)
