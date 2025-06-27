plugins {
    kotlin("jvm") version "2.1.21"
    kotlin("plugin.serialization") version "2.1.21"
    `maven-publish`
}

group = "dev.zornov.blockbench"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("parser") {
            from(components["java"])
            artifactId = "parser"
            groupId    = project.group.toString()
            version    = project.version.toString()

            pom {
                name.set("parser")
                description.set("Parser for models")
                url.set("https://github.com/Zornov/BlockBench-Parser")
                developers {
                    developer {
                        id.set("Zornov")
                        name.set("Sasha Zornov")
                    }
                }
            }
        }
    }
    repositories {
        mavenLocal()

        maven {
            name = "GitHubPackages"
            url  = uri("https://maven.pkg.github.com/Zornov/BlockBench-Parser")
            credentials {
                username = findProperty("gpr.user") as String
                password = findProperty("gpr.key")  as String
            }
            mavenContent { snapshotsOnly() }
        }
    }
}
