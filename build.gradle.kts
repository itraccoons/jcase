import com.google.gradle.osdetector.OsDetector

/*
 *
 */
plugins {
    java
    application
    checkstyle
    jacoco
    id("com.google.osdetector") version "1.6.0"
}

val checkstyleVersion by extra { "8.13" }
val jacocoVersion by extra { "0.8.2" }

checkstyle {
    toolVersion = checkstyleVersion
}

jacoco {
    toolVersion = jacocoVersion
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}


/*
val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

val jacocoTestCoverageVerification by tasks.getting(JacocoCoverageVerification::class) {
    "jacocoTestCoverageVerification"(JacocoCoverageVerification::class) {
        violationRules {
            rule { limit { minimum = BigDecimal.valueOf(0.7) } }
        }
        val check by tasks
        check.dependsOn(this)
    }
}

val os by tasks.creating {
    println("osdetector.os: " + osdetector.os)
    println("osdetector.arch: " + osdetector.arch)
    println("osdetector.release: " + osdetector.release)
}
*/

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }
    "jacocoTestCoverageVerification"(JacocoCoverageVerification::class) {
        violationRules {
            rule { limit { minimum = BigDecimal.valueOf(0.7) } }
        }
        val check by tasks
        check.dependsOn(this)
    }
    create("os") {
        println("osdetector.os: " + osdetector.os)
        println("osdetector.arch: " + osdetector.arch)
        println("osdetector.release: " + osdetector.release)
    }
}

version = "0.1.0"

application {
    mainClassName = "org.raccoons.backyards.TransformationJCase"
}
