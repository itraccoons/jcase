plugins {
    java
    jacoco
    application
    checkstyle
    "project-report"
}

val junitApiVersion by extra { "5.3.1" }
val jacocoVersion by extra { "0.8.2" }
val checkstyleVersion by extra { "8.13" }

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testImplementation("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:" + junitApiVersion)
}

jacoco {
    toolVersion = jacocoVersion
}

checkstyle {
    toolVersion = checkstyleVersion
}

allprojects {
    group = "org.raccoons"
    version = "0.1b1"

    repositories {
        mavenCentral()
        jcenter()
    }
}

val jacocoTestCoverageVerification by tasks.getting(JacocoCoverageVerification::class) {
    violationRules {
        rule {
            element = "BUNDLE"
            limit {
                minimum = BigDecimal.valueOf(0.6)
            }
        }
        rule {
            element = "CLASS"
            excludes = listOf("*TransformationJCase")
            limit {
                minimum = BigDecimal.valueOf(0.8)
            }
        }
    }
    val check by tasks
    check.dependsOn(this)
}

val jacocoTestReport by tasks.getting(JacocoReport::class) {
    reports.html.isEnabled = true
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
    // finalizedBy(jacocoTestReport)
}

application {
    mainClassName = "org.raccoons.backyards.TransformationJCase"
}
