#!/bin/sh
#
# Perform static analysis of the CI source code
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Fri Oct 5 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

echo "Running Shellcheck Script:"
echo "ShellCheck audit"
shellcheck --version
find .circleci/scripts/ -type f -name "*.sh" -exec shellcheck {} +

set +x
