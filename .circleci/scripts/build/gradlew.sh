#!/bin/sh

set -e
set -x

echo "Running Build"

#gradle os
#gradle build
#gradle run

./gradlew os
./gradlew build
./gradlew run

set +x
