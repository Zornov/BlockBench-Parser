package dev.zorinov.blockbench.model

import kotlinx.serialization.Serializable

@Serializable
data class BlockbenchModel(
    val meta: Meta? = null,
    val name: String,
    val elements: List<Element> = emptyList(),
    val outliner: List<OutlinerEntry> = emptyList(),
    val animations: List<AnimationEntry> = emptyList()
)