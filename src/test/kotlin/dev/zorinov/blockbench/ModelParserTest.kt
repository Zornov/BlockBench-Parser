package dev.zorinov.blockbench

import dev.zorinov.blockbench.model.BlockbenchModel
import dev.zorinov.blockbench.service.ModelParser
import java.io.File
import kotlin.test.Test

class ModelParserTest {
    @Test
    fun debugPrintModel() {
        val parser = ModelParser()
        val modelFile = File("model.json")
        val model: BlockbenchModel = parser.parse(modelFile)

        println("=== Model Debug Output ===")
        println("Model Name: ${model.name}")
        model.meta?.let { meta ->
            println("Meta:")
            println("  Format Version: ${meta.formatVersion}")
            println("  Model Format:   ${meta.modelFormat}")
            println("  Box UV:         ${meta.boxUv}")
        }

        println("\nElements (${model.elements.size}):")
        model.elements.forEach { e ->
            println("- Element:")
            println("    Name:   ${e.name}")
            println("    UUID:   ${e.uuid}")
            println("    From:   ${e.from}")
            println("    To:     ${e.to}")
            println("    Origin: ${e.origin}")
        }

        println("\nBones (${model.outliner.size}):")
        model.outliner.forEach { b ->
            println("- Bone:")
            println("    Name:     ${b.name}")
            println("    Origin:   ${b.origin}")
            println("    Children: ${b.children}")
        }

        println("\nAnimations (${model.animations.size}):")
        model.animations.forEach { anim ->
            println("* Animation:")
            println("    UUID:   ${anim.uuid}")
            println("    Name:   ${anim.name}")
            println("    Loop:   ${anim.loop}")
            println("    Length: ${anim.length}")
            println("    Animators (${anim.animators.size}):")
            anim.animators.forEach { (boneId, animator) ->
                println("    - Animator for Bone ID: ${boneId}")
                println("        Name:          ${animator.name}")
                println("        Type:          ${animator.type}")
                println("        Keyframes (${animator.keyframes.size}):")
                animator.keyframes.forEach { kf ->
                    println("        - Keyframe:")
                    println("            Channel:        ${kf.channel}")
                    println("            Time:           ${kf.time}")
                    println("            Interpolation:  ${kf.interpolation}")
                    println("            Data Points (${kf.dataPoints.size}):")
                    kf.dataPoints.forEach { dp ->
                        println("              (x=${dp.x}, y=${dp.y}, z=${dp.z})")
                    }
                }
            }
        }
    }
}
