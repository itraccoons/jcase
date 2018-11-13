#!/bin/sh
#
# Test code with Graddle Wrapper and JUnit5
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Tue Oct 23 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd
env

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

echo "Running Test Coverage Script:"
echo "Test coverage with Gradle Wrapper"

${sh_c} './gradlew jacocoTestReport jacocoTestCoverageVerification coveralls --console=plain'

curl -s https://codecov.io/bash | bash

${sh_c} "./gradlew sonarqube \
          -Dsonar.login=${SONARCLOUD_TOKEN} \
          --console=plain"
#          -Dsonar.projectKey=itraccoons_jcase \
#          -Dsonar.organization=itraccoons-github \
#          -Dsonar.host.url=https://sonarcloud.io \
#          -Dsonar.branch.name=${CIRCLE_BRANCH} \
#          -Dsonar.branch.target=master \

set +x
