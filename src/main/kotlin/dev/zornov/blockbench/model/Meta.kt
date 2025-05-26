package dev.zornov.blockbench.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("format_version") val formatVersion: String? = null,
    @SerialName("model_format") val modelFormat: String? = null,
    @SerialName("box_uv") val boxUv: Boolean? = null
)