# JOBGET MOBILE TESTING FRAMEWORK #

This is a gradle project that uses Appium, Java, Junit and Cucumber to automate tests flows on Android apps and contains the base code classes for running on iOS devices.

## GETTING STARTED ##

In order to be able of executing the project you have to install the following:
 
1) Java SDK 11  
2) Appium 1.21.0 or higher
3) Android Studio - for devices emulator
4) Docker (optional)
5) KVM - Virtualization option must be enabled in the BIOS

**Notes:** After installing Android Studio, launch the AVD Manager and install following device:
* **Pixel 4 XL API 28** --> (API 28, Android 9.0)

And then you should add the environment variables `ANDROID_HOME`, `ANDROID_TOOLS`, `ANDROID_PLATFORM` and `JAVA_HOME` on your machine

### Project Setup 
1. Clone this repository `git clone https://github.com/LerryAlexander/jobget-testing-framework.git`
2. Go to the root folder `cd jobget-testing-framework`.
3. Download the apk from this [URL](https://drive.google.com/u/0/uc?id=19FRROUB1l1SB3XLknoU9FIVdpHkR2XL2&export=download) and move it to path `src/resources/apps/android/` inside the repo:
    
    `mv /path/to/downloads/app-preproduction-jobget-14-jan.apk src/resources/apps/android/`

## RUNNING TESTS ##
For running tests you need to execute the `run-tests.sh` which receives two mandatory arguments:
* 1st argument is the run mode (**runMode**). Possible values are: `local`, `docker` or `cloud`
* 2nd argument is the test tags (**tags**). Possible values are: `regression`, `smoke` or `signInAsEmployer`

### RUNNING TESTS ON LOCAL ###
For running tests on your local you need to start Appium Server on port 4723

    ./run-tests.sh local smoke


### RUNNING TESTS ON DOCKER ###
For running tests on docker you need to have previously installed docker on your Linux machine. 
The option for running tests with docker is useful if you when you want to add your tests into a CI/CD pipeline. 

    ./run-tests.sh docker regression

### RUNNING TESTS ON BROWSERSTACK ###
For running tests on browserstack you need to create an account from the website https://www.browserstack.com/users/sign_in 
. However, for demo porpoises the following account was created:
* Username: `demo.falabella.123@gmail.com`
* Pass: `demo123`

Use above credentials to login and go to the **App Automate Dashboard** to see the test executions by running following command:

    ./run-tests.sh cloud signInAsEmployer

## TEST REPORT ##
Once the tests run have finished, you can check the report with the result of the test execution on following path:

```
 ./target/cucumberOptions/index.html
```

REFERENCES
---
- [Official Junit documentation](https://junit.org/junit5/)
- [Official Cucumber documentation](https://docs.cucumber.io/)
- [Official Appium documentation](http://appium.io/docs/en/about-appium/api/)
