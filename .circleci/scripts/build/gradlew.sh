#!/bin/sh

set -e
set -x

echo "Running Build"

gradle os
gradle build

set +x
