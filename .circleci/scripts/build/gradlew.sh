#!/bin/sh

set -e
set -x

echo "Running Build"

#gradle os
#gradle build
#gradle run

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
sh_c='sh -c'

${sh_c} './gradlew os'
${sh_c} './gradlew build'
${sh_c} './gradlew run'

set +x
