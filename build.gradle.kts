/*
 *
 */
plugins {
    java
    application
    checkstyle
    id("com.google.osdetector") version "1.6.0"
}

checkstyle {
    toolVersion = "8.13"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

val test by tasks.getting(Test::class) {
    //useJUnitPlatform()
    useJUnit()
}

tasks.create("os") {
    doLast {
        println("osdetector.os: " + osdetector.os)
        println("osdetector.arch: " + osdetector.arch)
        println("osdetector.release: " + osdetector.release)
    }
}

version = "0.1.0"

application {
    mainClassName = "org.raccoons.backyards.TransformationJCase"
}
