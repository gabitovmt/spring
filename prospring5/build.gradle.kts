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
var junitVersion = "6.0.2"

dependencies {
    implementation("org.springframework:spring-context:$springVersion")
    implementation("jakarta.annotation:jakarta.annotation-api:$jakartaAnnotationApiVersion")
    testImplementation("org.springframework:spring-test:$springVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}