#!/bin/sh
#
# Perform static analysis of the YAML config files
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 19 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

echo "Running YAML Lint Script:"
echo "YAML audit"
#need to add yamllint to dockerimage
#yamllint .circleci/config.yml

set +x
