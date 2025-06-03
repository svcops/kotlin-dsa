plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "io.intellij.kotlin.ads"
version = "1.0.0-SNAPSHOT"

val projectJdkVersion = libs.versions.java.get().toInt()

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(projectJdkVersion)
    }
}

kotlin {
    jvmToolchain(projectJdkVersion)
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
}

dependencies {
    implementation(libs.commons.lang3)
    implementation(libs.commons.collections4)
    implementation(libs.slf4j.api)
    implementation(libs.logback.classic)
    implementation(libs.logback.core)

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform() {
        includeEngines("junit-jupiter")
    }
}
