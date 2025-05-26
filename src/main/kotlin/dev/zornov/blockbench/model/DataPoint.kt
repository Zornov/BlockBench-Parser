package dev.zornov.blockbench.model

import kotlinx.serialization.Serializable

@Serializable
data class DataPoint(
    val x: String,
    val y: String,
    val z: String
)