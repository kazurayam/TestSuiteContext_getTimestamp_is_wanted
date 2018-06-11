import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import internal.GlobalVariable as GlobalVariable

class MyTestListener {
	
	static final String DATE_TIME_PATTERN = 'yyyyMMdd_HHmmss'
	
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		// resolve './Results' directory under the project directory
		GlobalVariable.RESULTS_DIR = 
			Paths.get(System.getProperty('user.dir')).resolve('Results')
		
		// resolve the test suite id.  e.g., 'TS1'
		GlobalVariable.CURRENT_TESTSUITE_NAME = 
		    testSuiteContext.getTestSuiteId().replaceFirst('Test Suites/','')
		
		// resolve the test suite timestamp.  e.g, '20180611_130937'
		GlobalVariable.CURRENT_TESTSUITE_TIMESTAMP = 
			DateTimeFormatter.ofPattern(DATE_TIME_PATTERN).format(LocalDateTime.now())
		
		// ************* the following code is much better IF POSSIBLE ************
		//GlobalVariable.CURRENT_TESTSUITE_TIMESTAMP = 
		//    testSuiteContext.getTestSuiteTimestamp()

	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
	}
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		GlobalVariable.CURRENT_TESTCASE_NAME = 
		    testCaseContext.getTestCaseId().replaceFirst('Test Cases/','')
	}

	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
	}
}