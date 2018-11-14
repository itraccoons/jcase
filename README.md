[![CircleCI](https://circleci.com/gh/itraccoons/jcase.svg?style=svg)](https://circleci.com/gh/itraccoons/jcase)

[![Coverage Status](https://coveralls.io/repos/github/itraccoons/jcase/badge.svg?branch=master)](https://coveralls.io/github/itraccoons/jcase?branch=master)
[![codecov](https://codecov.io/gh/itraccoons/jcase/branch/master/graph/badge.svg)](https://codecov.io/gh/itraccoons/jcase)

[![SonarCloud Bugs](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=bugs)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)
[![SonarCloud Code Smells](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=code_smells)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)
[![SonarCloud Coverage](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=coverage)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)
[![SonarCloud Duplicated Lines](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)
[![SonarCloud Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=alert_status)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)
[![SonarCloud Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=itraccoons_jcase&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=itraccoons_jcase)

# R-edu: JCase // Learning Java
This repository is my start point of learning Java.
For now my JCase has a lot of gaps, stubs or blackouts after 80 hours of
searching, reading, watching, trying, coding, sicking, whatever-ing...

Actually no Java code present - just simple peace of code to make IDE, build and CI work.

Unfortunately no OOP learning has been started yet but flashbacks and brain digging already in place.

### Development Environment

#### Hardware
MacBook Pro (13-inch, Mid 2012),  2.5 GHz Intel Core i5, 8 GB 1333 MHz DDR3	
	    
#### Software	
  * OS X Mojave 10.14.2 Beta (18C31g)
  * IDE IntelliJ IDEA 2018.2.5 (Community Edition) (https://www.jetbrains.com/idea/download/#section=mac)
  * SDK java 11.0.1 2018-10-16 LTS (https://www.oracle.com/technetwork/java/javase/downloads/index.html
  * BUILD MACHINE gradle-4.10.2 (IJ, standalone, docker+ci):
    * Kotlin DSL:   1.0-rc-6
    * Kotlin:       1.2.61
    * Groovy:       2.4.15
    * Ant:          1.9.11
  * GIT	git version 2.19.1 (Homwbrew)
  * CI CircleCI 2.0 (https://circleci.com/gh/itraccoons/jcase)
    * Notifications:
      * App SeaEye 0.5-dev (https://github.com/nolaneo/SeaEye)
      * IM Slack
    * Docker Image circleci/openjdk:11-jdk (https://hub.docker.com/r/circleci/openjdk/)
  * CODE QUALITY
	* jacoco (gradle plugin)
    * sonarqube 2.6.2 (gradle plugin)
    * coveralls 2.6.3 (gradle plugin)
    * codecov

### Continuous Integration Workflow
  * validate with:
  	* yamllint
	* shellcheck
	* checkstyle
	* ktlint
  * test with:
    * gradle plugins:
      * checkstyle
      * junit5
      * jacoco
      * build-dashboard
      * coveralls
      * sonarqube
  * build with:
	* gradlew

### Using Makefile locally and in-container
List all the available targets:

	$ make
    List of available commands:
	build                          Build a version
	clean                          Clean workspace
	depends                        Install software dependencies
	deploy                         [stub] Deploy a version
	docs                           [stub] Generate documentation
	help                           Print this help
	ktlint                         Run an anti-bikeshedding Kotlin linter
	lint                           Run all linters
	open                           [*] Open Build Dashboard (macOS local job)
	release                        [stub] Deploy a version
	shellcheck                     Run Shellcheck
	test-coverage                  Run test coverage
	test-unit                      Run Unit tests
	test                           Run all tests
	validate-ci                    Validate CI configuration
	validate-src                   Validate Source Code
	yamllint                       Run YAML Lint

Execute validation with Static Code Analysis

	$ make lint

Run all tests

	$ make test

Build the project

	$ make build
