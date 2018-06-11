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

I have implemented this approach with custom Groovy programing in TestListener, TestCase, and GlobalVariable. This github project demonstrates it.

### how to run the demo

- clone this project onto your PC
- open this project with Katalon studio
- load the test suite 'TS1'
- execuite the test suite
- in the project directory, you will find `Results` directory is created inside which you find a PNG file is stored.

then I got the following results:
![エビフライトライアングル](http://i.imgur.com/Jjwsc.jpg "Results")














The title should be simple, clear, and easy to understand.

Describe how these features can improve Katalon products (Katalon Studio, Katalon Analytics, Katalon Recorder), or how it optimize your automation process or why the current features need to be updated.

Include diagram, UI or videos to demonstrate your requests is a plus.

Impress us with your ideas. If you have the solution on how this can be implemented, feel free to let us know.

This category is only for requesting features. DO NOT post any bugs or issues within this category

Provide as much information as possible,  you will save us time to understand your suggestions, examples of your current situation/demand are preferred.  
