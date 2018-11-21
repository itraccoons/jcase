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
  tools=$1

  os="$( uname -s | tr '[:upper:]' '[:lower:]' )"
  case ${os} in
    linux) # install linters inside docker container
	  lsb_dist="$( get_distribution | tr '[:upper:]' '[:lower:]' )"
	  if [ "$lsb_dist" = "debian" ]; then
        sudo apt-get update
        package_manager_install="sudo apt-get -y install"
	  fi
	  ;;
	darwin) # install linters locally at macOS
	  package_manager_install="brew install"
	  ;;
  esac

  if [ ! -z "$package_manager_install" ]; then
    for tool in ${tools}; do
      if ! command_exists "${tool}"; then
	    eval "$package_manager_install $tool"
	  fi
    done
   else
     echo "package_manager_install is undefined"
   fi
}

echo "Running Dependencies Script:"

install_depends 'shellcheck yamllint'
