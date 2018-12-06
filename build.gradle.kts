import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    kotlin("jvm") version "1.2.71"
}

group = "isbn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    compile(kotlin("stdlib-jdk8"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
    testCompile("com.willowtreeapps.assertk:assertk-jvm:0.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
//val compileKotlin: KotlinCompile by tasks
//compileKotlin.kotlinOptions {
//    jvmTarget = "1.10"
//}
//val compileTestKotlin: KotlinCompile by tasks
//compileTestKotlin.kotlinOptions {
//    jvmTarget = "1.10"
//}

tasks.withType<Wrapper>().configureEach {
    gradleVersion = "5.0"
}