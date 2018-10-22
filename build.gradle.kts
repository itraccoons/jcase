/*
 *
 */

plugins {
    java
    application
    checkstyle
    id("com.google.osdetector") version "1.6.0"
}

repositories {
    mavenCentral()
    jcenter()
}

checkstyle {
    toolVersion = "8.13"
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
