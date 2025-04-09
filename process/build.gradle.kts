plugins {
    id("java-library")
}

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/com.google.auto.service/auto-service-annotations
    implementation("com.google.auto.service:auto-service-annotations:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")

    implementation("com.palantir.javapoet:javapoet:0.6.0")
    implementation("net.dv8tion:JDA:5.3.2")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
