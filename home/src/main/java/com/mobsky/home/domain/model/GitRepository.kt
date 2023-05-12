package com.mobsky.home.domain.model

import kotlin.math.ln
import kotlin.math.pow

data class GitRepository(
    val name: String = "",
    val description: String = "",
    val isPrivate: Boolean = false,
    val createdAt: String = "",
    val ownerName: String = "",
    val ownerAvatarUrl: String = "",
    val starCount: Int = 0,
    val forksCount: Int = 0
){

    fun getForkCountFormat(): String = getFormatNumber(forksCount.toLong())

    fun getStarCountFormat(): String = getFormatNumber(starCount.toLong())

    private fun getFormatNumber(count: Long): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }
}