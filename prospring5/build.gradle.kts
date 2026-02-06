plugins {
    id("java")
}

group = "prospring5"
version = "1.0"

repositories {
    mavenCentral()
}

val springVersion = "7.0.3"
val jakartaAnnotationApiVersion = "3.0.0"

dependencies {
    implementation("org.springframework:spring-context:$springVersion")
    implementation("jakarta.annotation:jakarta.annotation-api:$jakartaAnnotationApiVersion")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}