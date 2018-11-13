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
${sh_c} './gradlew jacocoTestReport jacocoTestCoverageVerification --console=plain'

# Upload Test Coverage reports to remote services if job executed inside docker-based CI
if [ -f /.dockerenv ]; then
  ${sh_c} './gradlew coveralls sonarqube --console=plain'
  curl -s https://codecov.io/bash | bash
else
  echo "LOCALLY SKIPPED: Uploading Test Coverage reports"
fi

set +x
