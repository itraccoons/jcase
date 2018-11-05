#!/bin/sh
#
# Perform static analysis of the source code
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
#sh_c='sh -c'

echo "UNUSED NOW"
echo "Running Lint Script:"

### echo "Google Java Style audit"
### find src/ -type f -name "*.java" -exec java -jar .circleci/scripts/validate/checkstyle-8.13-all.jar -c .circleci/scripts/validate/google_checks.xml {} +
###
### find scripts/ -type f | grep -v scripts/winresources | xargs shellcheck

set +x
