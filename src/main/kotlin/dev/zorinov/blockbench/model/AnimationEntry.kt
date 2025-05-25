package dev.zorinov.blockbench.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimationEntry(
    val uuid: String,
    val name: String,
    val loop: String,
    @SerialName("length") val length: Double,
    @SerialName("animators") val animators: Map<String, Animator> = emptyMap()
)