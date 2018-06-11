TestSuiteContext#getTimestamp() is wanted
=========================================

## What is this repository

This is a simple [Katalon Studio](https://www.katalon.com/) project for demonstration purpose.
You can clone this out on your PC and execute it with your local Katalon Studio.

This proejct is created with Katalon Studio version 5.4.2




## What I wanted to achieve

With Katalon Studio I can easily start Web UI automated testing with WebDriver. With [WebUI.takeScreenshot(path)](https://docs.katalon.com/display/KD/%5BWebUI%5D+Take+Screenshot) I can take screenshots of target Web pages and save them into local files. But here I find an itchy problem: how to resolve the path of image files?

To tell conclusion first, I want to save screenshot files in the following location:

```
<project dir>/Results/<TestSuite name>/<TestSuite timestamp>/<TestCase name>/<encoded URL string>.png
```

for example:

```
./Results/TS1/20180611_140156/TC1/http%3A%2F%2Fdemoaut.katalon.com%2F.png
```

I have implemented this approach with custom Groovy programing in TestListener, TestCase, and with GlobalVariables. This GitHub project demonstrates it.

## how to run the demo

- clone this project onto your PC
- open this project with Katalon studio
- load the test suite 'TS1'
- execute the test suite with any browser you like
- in the project directory, you will find the `Results` directory is newly created.
- in the `Results` directory you find a PNG file.

then I got the Results directory and screenshot file as follows:
![Results directory and screenshot files](https://github.com/kazurayam/TestSuiteContext_getTimestamp_is_wanted/blob/master/docs/screenshot_saved_in_the_Results_dir.png "Results")

## How I implemented my idea

In the above screenshot, you would find a directory named `Results/TS1/20180611_140159`. This is made my custom Groovy scripts. Have a look at the  [TestListener](https://github.com/kazurayam/TestSuiteContext_getTimestamp_is_wanted/blob/master/Test%20Listeners/MyTestListener.groovy). I wrote as follows:
```
        // resolve the test suite timestamp.  e.g, '20180611_130937'
		GlobalVariable.CURRENT_TESTSUITE_TIMESTAMP =
			DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).
                format(LocalDateTime.now())
```
Here I got the timestamp from the current machine clock, and formatted the time value into a string of '20180611_140159'.

I felt comfortable enough with the screenshot file path: `./Results/TS1/20180611_140156/TC1/http%3A%2F%2Fdemoaut.katalon.com%2F.png`.

If I repeatedly execute the Test Suite `TS1`, each TS1 execution will result in indivisual directory; differenciated by the timestamp value. I can preserve multiple versions of screenshot images. This means, I can compare the current screenshot with other versions in automated way. The following article describes how to implement it with Image Magick.

 -  [Hotwrire Tech Blog: Image Comparison in Automated Testing ](http://techblog.hotwire.com/2016/05/19/image-comparison-in-automated-testing/)

Provided that the screenshots files are well organized, I can integrate Image Magick with Katalon Studio. Then Katalon Studio would newly equip a feature of Visual Testing.

## Problem found

On the other hand you find in the above screenshot a diretory named `./Reports/TS1/20180611_140156`. This directory was created by Katalon Studio.









Describe how these features can improve Katalon products (Katalon Studio, Katalon Analytics, Katalon Recorder), or how it optimize your automation process or why the current features need to be updated.

Include diagram, UI or videos to demonstrate your requests is a plus.

Impress us with your ideas. If you have the solution on how this can be implemented, feel free to let us know.

This category is only for requesting features. DO NOT post any bugs or issues within this category

Provide as much information as possible,  you will save us time to understand your suggestions, examples of your current situation/demand are preferred.  
