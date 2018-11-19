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
    id("com.github.kt3k.coveralls") version "2.6.3" // [draft] to remove
    id("org.sonarqube") version "2.6.2" // Continuous inspection of code quality
    id("com.google.cloud.tools.jib") version "0.10.0" // Building Docker and OCI images for Java application
    id("org.gretty") version "2.2.0"
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
val packageName by extra { "org.raccoons.backyards" }
val mainClass by extra { "TransformationJCase" }
val checkstyleVersion by extra { "8.13" }
val checkstyleConfigFile by extra { "config/checkstyle/google_checks.xml" }
val junitApiVersion by extra { "5.3.1" }
val jacocoVersion by extra { "0.8.2" }
val minimumBundleCoverage by extra { 0.6 }
val minimumClassCoverage by extra { 0.6 }

dependencies {
    // implementation("com.google.guava:guava:27.0-jre")
    // implementation("com.google.http-client:google-http-client:1.27.0")
    // implementation("org.apache.httpcomponents:httpclient:4.5.6")
    implementation("com.google.cloud.tools:jib-core:0.1.0")
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
    mainClassName = packageName + "." + mainClass
}

checkstyle {
    toolVersion = checkstyleVersion
    configFile = rootProject.file(checkstyleConfigFile)
}

jacoco {
    toolVersion = jacocoVersion
}

sonarqube {
    properties {
        property("sonar.projectKey", System.getenv("CIRCLE_PROJECT_USERNAME") + "_" + System.getenv("CIRCLE_PROJECT_REPONAME"))
        property("sonar.organization", System.getenv("CIRCLE_PROJECT_USERNAME") + "-github")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", System.getenv("SONARCLOUD_TOKEN"))
        property("sonar.branch.name", System.getenv("CIRCLE_BRANCH"))
        // property("sonar.branch.target", "master") // commented because the main(master) branch must not have a target
        property("sonar.java.checkstyle.reportPaths", "build/reports/checkstyle/main.xml,build/reports/checkstyle/test.xml")
    }
}

jib {
    /*
    from{
        image = "circleci/openjdk:11-jdk"
    }
    */
    to {
        image = "gcr.io/td-jcase/jcase:" + project.version
        credHelper = "gcr"
    }
}

gretty {
    httpEnabled = true
    httpPort = 8080
    httpsEnabled = true
    // httpsPort = 443
    servletContainer = "jetty9"
}

/*
 * Enable required Checkstyle reports formats (HTML, XML).
 * Note: build-dashboard plugin depends on these setting
 */
tasks.withType<Checkstyle> {
    reports.html.isEnabled = true
    reports.xml.isEnabled = true
    /*
     * reports{
     *   html.isEnabled = true
     *   xml.isEnabled = false
     * }
     */
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
            excludes = listOf("*" + mainClass)
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
