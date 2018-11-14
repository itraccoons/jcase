#!/bin/sh
#
# We do here installation of required software to perform Analysis
# Written by: Oleksii Kucheruk <ok@raccoons.co> on Wed Nov 14 2018

##
# Exit immediately if a command exits with a non-zero status
set -e

# Print commands and their arguments as they are executed
set -x

pwd

# Using 'sh -c' can avoid situation then VCS do not preserves file permissions
#sh_c='sh -c'

get_distribution() {
  lsb_dist=""
  if [ -r /etc/os-release ]; then
    # Allow 'source' outside of FILES (see shellcheck -x) or
    # shellcheck disable=SC1091
    lsb_dist="$(. /etc/os-release && echo "$ID")"
  fi
  echo "$lsb_dist"
}

command_exists() {
  command -v "$@" > /dev/null 2>&1
}

install_depends()
{
  os="$( uname -s | tr '[:upper:]' '[:lower:]' )"
  case ${os} in
    linux)
	  lsb_dist="$( get_distribution | tr '[:upper:]' '[:lower:]' )"
	  if [ "$lsb_dist" = "ubuntu" ] || [ "$lsb_dist" = "debian" ]; then
        sudo apt-get update
		sudo apt-get -y install shellcheck yamllint
	  fi
	  ;;
	darwin)
	  for cmd in shellcheck yamllint; do
	    if ! command_exists ${cmd}; then
	      brew install ${cmd}
	    fi
	  done
	  ;;
  esac
}

echo "Running Dependencies Script:"

install_depends
