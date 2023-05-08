val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val commonstext_version: String by project
val opentsdb_version: String by project

plugins {
    kotlin("jvm") version "1.8.21"
    id("io.ktor.plugin") version "2.2.4"
}

group = "no.nav.demo"
version = "0.0.1"

application {
    mainClass.set("no.nav.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.apache.commons:commons-text:$commonstext_version")
    implementation("net.opentsdb:opentsdb:opentsdb:$opentsdb_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

tasks {
    withType<Wrapper> {
        gradleVersion = "8.1.1"
    }
}
