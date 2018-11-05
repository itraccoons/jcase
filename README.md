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

### Using Makefile locally and in-container
List all the available targets:

	$ make
    List of available commands:
    build                          Build a version
    clean                          Clean workspace
    deploy                         [stub] Deploy a version
    docs                           [stub] Generate documentation
    help                           Print this help
    ktlint                         Run an anti-bikeshedding Kotlin linter
    lint                           Run all linters
    release                        [stub] Release a version
    shellcheck                     Run Shellcheck
    test-coverage                  Run test coverage
    test-unit                      Run Unit tests
    test                           Run all tests
    validate-ci                    Validate CI configuration
    validate-src                   Validate Source Code
    yamllint                       Run YAML Lint

Run source code validation

	$ make validate-src

Build the project

	$ make build

<p align="left">
  <img src="https://scontent.fhrk1-1.fna.fbcdn.net/v/t1.0-9/43756480_1194500660718042_3407559282357436416_n.png?_nc_cat=105&_nc_ht=scontent.fhrk1-1.fna&oh=454789711c1d02145e22f8c492a421b5&oe=5C8A76E0" width="240" title="R-edu"
</p>
