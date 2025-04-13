plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    // discord
    implementation("net.dv8tion:JDA:5.3.2")

    // .env
    implementation("io.github.cdimascio:dotenv-java:3.2.0")

    // json serialization library
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.3")

    // sub project for processing code at compile-time
    implementation(project(":process"))
    annotationProcessor(project(":process"))

    // sub project for shared objects
    implementation(project(":api-data"))

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.38")
	annotationProcessor("org.projectlombok:lombok:1.18.38")
	testCompileOnly("org.projectlombok:lombok:1.18.38")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.38")

    // memory cache
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.0")

    // https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.11.0")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.3")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "dev.cwby.butecobot.ButecoBot";
}

