plugins {
    id("java")
}

group = "ru.maratgabitov.prospring5"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val springVersion = "7.0.3"

dependencies {
    implementation("org.springframework:spring-context:$springVersion")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}