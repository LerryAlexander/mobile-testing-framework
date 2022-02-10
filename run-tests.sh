#!/bin/bash
function check_emulator_is_ready () {
  boot_completed=false
  while [ "$boot_completed" == false ]; do
    if [ $1 = "local" ]; then
      status=$(adb wait-for-device shell getprop sys.boot_completed | tr -d '\r')
    else
      status=$(docker exec sf_jobget-testing-framework_nexus_7.0_1 -it adb wait-for-device shell getprop sys.boot_completed | tr -d '\r')
    fi
    echo "Waiting for emulator to be ready..."

    if [ "$status" == "1" ]; then
      boot_completed=true
      echo "Emulator is ready"
    else
      sleep 1
    fi
  done
}

echo "Starting android emulator"

if [ ! -z "$1" ]; then
  if [ $1 = "local" ]; then
    echo "Running emulator on: $1"
    /${ANDROID_HOME}/emulator/emulator -avd Pixel_4_XL_API_28 -writable-system &
  elif [ $1 = "docker" ]; then
    echo "Running emulator on: $1"
    docker-compose up -d
  elif [ $1 = "cloud" ]; then
      echo "Emulator will run on a cloud service"
  else
    echo "$1 first argument should be: local, docker or cloud. Try again"
    exit 1
  fi
else
  echo "$1 env argument is not given! Please pass it through bash execution as first argument!"
  exit 1
fi

if [ $1 = "local" ] || [ $1 = "docker" ]; then
  check_emulator_is_ready $1
fi

echo "Starting tests execution..."
if [ ! -z "$2" ]; then
  echo "tag to be executed: @$2"
  bash ./gradlew clean test -Dcucumber.options="--tags @$2" -DrunMode=$1 -Dplatform=android -DplatformVersion=9.0 -DdockerAndroidName="Nexus 5" -DlocalAndroidName=Pixel_4_XL_API_28
else
  echo "$2 tag argument is not given! Please pass it through bash execution as second argument!"
  exit 1
fi


