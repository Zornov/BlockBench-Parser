# Blockbench Model Parser

[![License](https://img.shields.io/badge/license-CC--BY--NC%204.0-blue)](https://creativecommons.org/licenses/by-nc/4.0/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.21-blue)](https://kotlinlang.org/)

> JSON model parser for Blockbench exports, written in Kotlin

---

## Features

| Feature           | Description                                                                   |
|-------------------|-------------------------------------------------------------------------------|
| **Model parsing** | Reads and deserializes Blockbench `.json` files into structured Kotlin models |
| **Elements**      | Full support for geometric elements (position, size, UUID, etc.)              |
| **Bones**         | Parses bone hierarchy and origin points                                       |
| **Animations**    | Parses keyframe animations including channels, curves, and interpolation      |
| **Metadata**      | Supports parsing of model metadata (version, format, boxUV, etc.)             |

---

## Usage Example

```kotlin
val parser = ModelParser()
val model = parser.parse(File("model.json"))

println("Model name: ${model.name}")
model.elements.forEach { println("Element: ${it.name}") }
model.outliner.forEach { println("Bone: ${it.name}") }
```

---

## Model Structure

### BlockbenchModel

| Field        | Type              | Description                    |
| ------------ | ----------------- | ------------------------------ |
| `name`       | `String`          | Model name                     |
| `meta`       | `Meta?`           | Format and version information |
| `elements`   | `List<Element>`   | Geometric parts of the model   |
| `outliner`   | `List<Bone>`      | Bone hierarchy                 |
| `animations` | `List<Animation>` | Animation data                 |

### Example Output (from test)

```
=== Model Debug Output ===
Model Name: ExampleModel

Meta:
  Format Version: 4
  Model Format: Java Block
  Box UV: true

Elements (3):
- Element:
    Name: Cube
    UUID: ...
    From: [0, 0, 0]
    To:   [16, 16, 16]
    Origin: [8, 8, 8]

Bones (2):
- Bone:
    Name: Arm
    Origin: [4, 8, 0]
    Children: [Hand]

Animations (1):
* Animation:
    UUID: ...
    Name: Walk
    Loop: true
    Length: 1.2
    Animators (1):
    - Animator for Bone ID: Arm
        Keyframes (2):
        - Keyframe:
            Channel: rotation
            Time: 0.0
            Interpolation: linear
            Data Points:
              (x=0, y=0, z=0)
```

---

## Run Debug Output

This project includes a test class `ModelParserTest` that demonstrates full deserialization and console output of a `.json` Blockbench model.

```kotlin
@Test
fun debugPrintModel() {
    val parser = ModelParser()
    val model = parser.parse(File("model.json"))
    // Prints formatted structure to the console
}
```

---

## License

This project is licensed under the [Creative Commons Attribution-NonCommercial 4.0 International License](https://creativecommons.org/licenses/by-nc/4.0/).

Copyright © 2025
Sasha Zorov
