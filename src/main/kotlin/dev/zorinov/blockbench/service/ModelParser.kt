package dev.zorinov.blockbench.service

import dev.zorinov.blockbench.model.BlockbenchModel
import kotlinx.serialization.json.Json
import java.io.File

class ModelParser(val json: Json = Json { ignoreUnknownKeys = true }) {
    fun parse(file: File): BlockbenchModel {
        return file.readText().let { text ->
            json.decodeFromString(BlockbenchModel.serializer(), text)
        }
    }
}