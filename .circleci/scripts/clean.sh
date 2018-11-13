#!/bin/sh
#
# We do here cleaning jobs
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Wed Oct 31 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

echo "Running Cleanup Script:"
${sh_c} './gradlew clean --console=plain'
