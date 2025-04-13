plugins {
    id("java-library")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}
