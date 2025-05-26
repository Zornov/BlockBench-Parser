package dev.zornov.blockbench.model

import kotlinx.serialization.Serializable

@Serializable
data class Element(
    val name: String,
    val uuid: String,
    val from: List<Double> = emptyList(),
    val to: List<Double> = emptyList(),
    val origin: List<Double> = emptyList()
)