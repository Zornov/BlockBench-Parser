package dev.zornov.blockbench.model

import kotlinx.serialization.Serializable

@Serializable
data class OutlinerEntry(
    val name: String,
    val origin: List<Double> = emptyList(),
    val children: List<String> = emptyList()
)