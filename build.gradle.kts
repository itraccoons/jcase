/*
 * Gradle Build with Kotlin DSL
 *
 * Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 12 2018
 */

plugins {
    java
    jacoco // Java Code Coverage Library
    application
    checkstyle // Static code analysis for Java source code
    `project-report`
    `build-dashboard`
}

/*
 * Create read-only ext variables
 */
val junitApiVersion by extra { "5.3.1" }
val jacocoVersion by extra { "0.8.2" }
val checkstyleVersion by extra { "8.13" }
val checkstyleConfigFile by extra { "config/checkstyle/google_checks.xml" }
val minimumBundleCoverage by extra { 0.6 }
val minimumClassCoverage by extra { 0.8 }

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
    configFile = rootProject.file(checkstyleConfigFile)
}

allprojects {
    group = "org.raccoons"
    version = "0.1b1"

    repositories {
        mavenCentral()
        jcenter()
    }
}

application {
    mainClassName = "org.raccoons.backyards.TransformationJCase"
}

/*
 * Enable required Checkstyle reports formats (HTML, XML).
 * Note: build-dashboard plugin depends on these setting
 */
tasks.withType<Checkstyle> {
    reports.html.isEnabled = true
    reports.xml.isEnabled = false
    /*
     * reports{
     *   html.isEnabled = true
     *   xml.isEnabled = false
     * }
     */
}

/*
 * Enable required JaCoCo reports formats (HTML, XML, CSV).
 * Note: build-dashboard plugin depends on these setting
 */
val jacocoTestReport by tasks.getting(JacocoReport::class) {
    reports.html.isEnabled = true
    reports.xml.isEnabled = false
    reports.csv.isEnabled = false
}

/*
 * Set Code Coverage minimum limits for Bundle and Classes.
 * Exclude main class
 */
val jacocoTestCoverageVerification by tasks.getting(JacocoCoverageVerification::class) {
    violationRules {
        rule {
            element = "BUNDLE"
            limit {
                minimum = BigDecimal.valueOf(minimumBundleCoverage)
            }
        }
        rule {
            element = "CLASS"
            excludes = listOf("*TransformationJCase")
            limit {
                minimum = BigDecimal.valueOf(minimumClassCoverage)
            }
        }
    }
    val check by tasks
    check.dependsOn(this)
}

/*
 * Enable native support for JUnit.
 * Add to test task jacocoTestReport execution
 */
val test by tasks.getting(Test::class) {
    useJUnitPlatform()
    finalizedBy(jacocoTestReport)
}
