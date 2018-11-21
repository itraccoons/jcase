#!/bin/sh
#
# Build Docker image with Skaffold
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Wed Nov 21 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'


if ! command -v skaffold; then
  os="$( uname -s | tr '[:upper:]' '[:lower:]' )"
  curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-"${os}"-amd64 && chmod +x skaffold
  sudo mv skaffold /usr/local/bin
fi

echo "Running Build Script:"
echo "Skaffold Tasks"

docker -v
#${sh_c} 'skaffold build'
# ${sh_c} 'skaffold run'

set +x
