#!/bin/sh
#
# Perform static analysis of the CI source code
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Mon Oct 22 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
#sh_c='sh -c'

echo "Running Kotlin Linter Script:"
echo "Kotlin audit"

find . -type f -name "*.kts" -exec .circleci/scripts/validate/ktlint {} +
#find . -type f -name "*.kts" | xargs .circleci/scripts/validate/ktlint

set +x
