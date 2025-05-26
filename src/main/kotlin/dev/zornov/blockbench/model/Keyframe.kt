package dev.zornov.blockbench.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Keyframe(
    val channel: String,
    @SerialName("data_points") val dataPoints: List<DataPoint> = emptyList(),
    val time: Double,
    val interpolation: String
)