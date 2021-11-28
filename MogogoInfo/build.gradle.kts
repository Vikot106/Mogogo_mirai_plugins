plugins {
    val kotlinVersion = "1.5.10"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.8.2"
}

group = "ink.moku"
version = "1.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}
dependencies {
    implementation("org.json:json:20210307")
}
