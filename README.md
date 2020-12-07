# Welcome to Lambdatest - Java JUnit Selenium 

## Step 1: Configure your settings and required capabilites for your test

For running a test we will need your `username` and `access key` to map with our cloud infrastrure. 

You can find the required credentials here : <https://www.lambdatest.com/capabilities-generator>

### Change the properties 

Add your Lambdatest `username` and `access key` in `Config.properties` file
```
ln 9: LambdaTest_UserName=<YOUR LT_USERNAME>
ln 10: LambdaTest_AppKey=<YOUR LT_ACCESS_KEY>
```

## Step 2: Running Tests

We have preinstalled all the required environment for running the tests. You can now execute the tests in the console by the following commands: 

#### To run single test
```
$ mvn test -P single
```


## Step 3: Test Results

Once you have completed running the tests you can find the results at : <https://automation.lambdatest.com> with the build name `TestNG` as a prefix. 

For any other quires please connect with us at <support.lambdatest.com>

### Happy testing! :computer:
