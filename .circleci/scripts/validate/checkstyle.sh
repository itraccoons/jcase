#!/bin/sh
#
# Perform static analysis of the source code
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

echo "Running Checkstyle Script:"
echo "Google Java Style audit"
java -jar .circleci/tools/checkstyle-8.13-all.jar -v
find src/ -type f -name "*.java" -exec java -jar .circleci/tools/checkstyle-8.13-all.jar -c .circleci/tools/google_checks.xml {} +
${sh_c} './gradlew checkstyleMain checkstyleTest'

set +x
