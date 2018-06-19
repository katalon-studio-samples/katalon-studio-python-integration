
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import org.openqa.selenium.WebElement


def static "com.example.WebUICustomKeywords.isElementPresent"(
    	TestObject to	
     , 	int timeout	) {
    (new com.example.WebUICustomKeywords()).isElementPresent(
        	to
         , 	timeout)
}

def static "com.example.WebUICustomKeywords.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new com.example.WebUICustomKeywords()).getHtmlTableRows(
        	table
         , 	outerTagName)
}

def static "com.example.WebUICustomKeywords.getHtmlTableColumns"(
    	WebElement row	
     , 	String tagName	) {
    (new com.example.WebUICustomKeywords()).getHtmlTableColumns(
        	row
         , 	tagName)
}

def static "demo.PythonKeywords.helloWorld"(
    	int a	
     , 	int b	) {
    (new demo.PythonKeywords()).helloWorld(
        	a
         , 	b)
}

def static "demo.PythonKeywords.gotoGoogle"() {
    (new demo.PythonKeywords()).gotoGoogle()
}

def static "test.Test.refreshBrowser"() {
    (new test.Test()).refreshBrowser()
}

def static "test.Test.clickElement"(
    	TestObject to	) {
    (new test.Test()).clickElement(
        	to)
}

def static "test.Test.getHtmlTableRows"(
    	TestObject table	
     , 	String outerTagName	) {
    (new test.Test()).getHtmlTableRows(
        	table
         , 	outerTagName)
}
