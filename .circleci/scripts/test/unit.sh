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

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

echo "Running Unit Test Script:"
echo "Running Unit Test Script:"echo "Unit tests with Gradle Wrapper"

${sh_c} './gradlew test --console=plain'

set +x
