package dev.zorinov.blockbench.model

import kotlinx.serialization.Serializable

@Serializable
data class Animator(
    val name: String,
    val type: String,
    val keyframes: List<Keyframe> = emptyList()
)
