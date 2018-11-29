#!/bin/sh
#
# Build code with Graddle Wrapper
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Thu Oct 18 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

echo "Running Build Script:"
echo "Gradle Tasks"

${sh_c} './gradlew --version'
#${sh_c} './gradlew build projectReport --console=plain -x jacocoTestCoverageVerification'
${sh_c} './gradlew clean build projectReport --console=plain -x check'
${sh_c} './gradlew javadoc'
#${sh_c} './gradlew run'

set +x
