plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "com.nasko"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("net.dv8tion:JDA:5.0.0-beta.12")
    implementation("org.slf4j:slf4j-api:2.0.9")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnit()
}

application {
    mainClass.set("com.nasko.MainKt")
}

kotlin {
    jvmToolchain(11)
}