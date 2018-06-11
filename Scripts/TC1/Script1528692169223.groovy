import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.nio.file.Files
import java.nio.file.Path

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demoaut.katalon.com/')

WebUI.verifyElementPresent(
	findTestObject('Page_CURA Healthcare Service/a_Make Appointment'),
	10, FailureHandling.STOP_ON_FAILURE)


// resolve file path where we store the captured image
//
// ===> ./Results/TS1/yyyyMMdd_hhmmss/TC1/http%3A%2F%2Fdemoaut.katalon.com%2F.png
//
Path resultsDir = (Path)GlobalVariable.RESULTS_DIR
String tSuiteName = GlobalVariable.CURRENT_TESTSUITE_NAME
String tSuiteTimestamp = GlobalVariable.CURRENT_TESTSUITE_TIMESTAMP
String tCaseName = GlobalVariable.CURRENT_TESTCASE_NAME
String fileName = URLEncoder.encode('http://demoaut.katalon.com/', 'UTF-8') + '.png'
Path pngFile = resultsDir.resolve("${tSuiteName}/${tSuiteTimestamp}/${tCaseName}/${fileName}")
ensureParentDirs(pngFile)

WebUI.takeScreenshot(pngFile.toString(), FailureHandling.STOP_ON_FAILURE)
WebUI.comment("saved screenshot into ${pngFile.toString()}")

WebUI.closeBrowser()


def ensureParentDirs(Path file) {
	Path parent = file.getParent()
	Files.createDirectories(parent)
}