package com.mobsky.home.data.network.api.model.user_repository


import com.google.gson.annotations.SerializedName

data class SecurityAndAnalysis(
    @SerializedName("advanced_security")
    val advancedSecurity: AdvancedSecurity,
    @SerializedName("secret_scanning")
    val secretScanning: SecretScanning,
    @SerializedName("secret_scanning_push_protection")
    val secretScanningPushProtection: SecretScanningPushProtection
)