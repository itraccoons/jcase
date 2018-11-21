#!/bin/sh
#
# Perform static analysis of the YAML config files
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 19 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

echo "Running YAML Lint Script:"
echo "YAML audit"

yamllint --version

find . -type f -name "*.yml" -exec yamllint {} +

set +x
