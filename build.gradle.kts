plugins {
    java
}

repositories {
    mavenCentral()
}

group = "com.devmind.testinaction"
version = "0.0.1-SNAPSHOT"

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}


dependencies {
    implementation("org.springframework:spring-context-support:6.0.11")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.4.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


