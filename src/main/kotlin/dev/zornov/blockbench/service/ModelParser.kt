package dev.zornov.blockbench.service

import dev.zornov.blockbench.model.BlockbenchModel
import kotlinx.serialization.json.Json
import java.io.File

class ModelParser(val json: Json = Json { ignoreUnknownKeys = true }) {
    fun parse(file: File): BlockbenchModel {
        return file.readText().let { text ->
            json.decodeFromString<BlockbenchModel>(text)
        }
    }
}