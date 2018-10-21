# R-edu: JCase // Learning Java
This repository is my start point of learning Java.
For now my JCase has a lot of gaps, stubs or blackouts after 60 hours of
searching, reading, watching, trying, coding, sicking, whatever-ing...

Actually no Java code present - just simple peace of code to make IDE, build and CI work.
_My Circle based on java.awt.Point with some sort of overloading for _

Unfortunately no OOP learning has been started yet but flashbacks and brain digging already in place.


### Development Environment

#### Hardware
MacBook Pro (13-inch, Mid 2012),  2.5 GHz Intel Core i5, 8 GB 1333 MHz DDR3	
	    
#### Software	
  * OS X El Capitan 10.11 beta (15A278b)	
  * IDE IntelliJ IDEA 2018.2.4 (Community Edition) (https://www.jetbrains.com/idea/download/#section=mac)
  * SDK:
    * java 10.0.2 2018-07-17 (https://www.oracle.com/technetwork/java/javase/downloads/index.html
    * groovy-2.5.2 (Homebrew)
  * BUILD MACHINE gradle-4.10.2 (IJ, standalone, docker+ci)
  * GIT	git version 2.19.1 (Homwbrew)
  * SCM	GitHub (https://github.com/itraccoons/jcase)
  * CI CircleCI 2.0 (https://circleci.com/gh/itraccoons/jcase)
    * Notifications:
      * App SeaEye 0.5-dev (https://github.com/nolaneo/SeaEye)
      * IM Slack _(not installed for now)_	
    * Docker Image circleci/openjdk:10-jdk (https://hub.docker.com/r/circleci/openjdk/)

### Using Makefile locally and in-container
List all the available targets:

	$ make
    List of available commands:
    build                          Build a version
    clean                          Clean workspace
    deploy                         Deploy a version
    help                           Print this help
    lint                           Run linters for source code
    shellcheck                     Run Shellcheck
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
