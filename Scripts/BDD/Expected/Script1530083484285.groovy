import cucumber.api.java.en.Given as Given
import cucumber.api.java.en.Then as Then
import cucumber.api.java.en.When as When
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

@Given(value = 'today is 2011-01-20')
def today_is() {
    WebUI.openBrowser('https://google.com')
}

@When(value = 'I ask if Jan 19, 2011 is in the past')
def I_ask_if_date_is_in_the_past() {
    WebUI.openBrowser('https://google.com')
	WebUI.openBrowser('https://google.com')
	WebUI.openBrowser('https://google.com')
	WebUI.openBrowser('https://google.com')
	WebUI.openBrowser('https://google.com')
}

@Then(value = 'the result should be yes')
def the_result_should_be() {
    WebUI.openBrowser('https://google.com')
}

