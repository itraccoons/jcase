/*
 * Gradle Build with Kotlin DSL
 *
 * Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 12 2018
 */

plugins {
    java
    application
    checkstyle // Static code analysis for Java source code
    jacoco // Java Code Coverage Library
    `project-report`
    `build-dashboard`
    id("com.github.kt3k.coveralls") version "2.6.3"
    id("org.sonarqube") version "2.6"
    // id("com.github.spotbugs") version "1.6.5" - Unsupported class file major version 55
    // findbugs
}

allprojects {
    group = "org.raccoons"
    version = "0.1b1"

    repositories {
        mavenCentral()
        jcenter()
        google()
    }
}

/*
 * Create read-only ext variables
 */
val checkstyleVersion by extra { "8.13" }
val checkstyleConfigFile by extra { "config/checkstyle/google_checks.xml" }
val guavaVersion by extra { "27.0-jre" }
val junitApiVersion by extra { "5.3.1" }
val jacocoVersion by extra { "0.8.2" }
val minimumBundleCoverage by extra { 0.6 }
val minimumClassCoverage by extra { 0.6 }
val spotbugsVersion by extra { "3.1.3" }

dependencies {
    // compile("com.google.guava:guava:" + guavaVersion)
    testCompile("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testImplementation("org.junit.jupiter:junit-jupiter-api:" + junitApiVersion)
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:" + junitApiVersion)
}

/*
 * java {
 *     targetCompatibility = JavaVersion.VERSION_1_10
 *     sourceCompatibility = JavaVersion.VERSION_1_10
 * }
 */

application {
    mainClassName = "org.raccoons.backyards.TransformationJCase"
}

checkstyle {
    toolVersion = checkstyleVersion
    configFile = rootProject.file(checkstyleConfigFile)
}

jacoco {
    toolVersion = jacocoVersion
}

/*
 * spotbugs {
 *     toolVersion = spotbugsVersion
 * }
 */
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

tasks.withType<FindBugs> {
    reports.html.isEnabled = true
    reports.xml.isEnabled = false
    reports.text.isEnabled = false
    reports.emacs.isEnabled = false
}

/*
 * Enable required JaCoCo reports formats (HTML, XML, CSV).
 * Note: build-dashboard plugin depends on these setting;
 * coveralls plugin depends on xml format report
 */
val jacocoTestReport by tasks.getting(JacocoReport::class) {
    reports.html.isEnabled = true
    reports.xml.isEnabled = true
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
