package com.mobsky.home.data.network.api.model.user_repository


import com.google.gson.annotations.SerializedName

data class SecretScanning(
    @SerializedName("status")
    val status: String
)