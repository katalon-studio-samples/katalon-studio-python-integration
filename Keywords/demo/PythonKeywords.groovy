package demo
import org.openqa.selenium.support.events.EventFiringWebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.BrowserNotOpenedException


class PythonKeywords {

	@Keyword
	def helloWorld(int a, int b) {
		runPython("keywords.hello_world", a, b)
	}

	@Keyword
	def gotoGoogle() {
		runPython("keywords.goto_google")
	}

	private runPython(String script, Object[] keywordArgs) {
		try {
			KeywordUtil.logInfo(Arrays.deepToString(keywordArgs))
			def outputFile = File.createTempFile("ks_py_output_", ".tmp")
			KeywordUtil.logInfo(outputFile.absolutePath)

			def allArgs = [
				keyword: script,
				keywordArgs: keywordArgs,
				outputPath: outputFile.absolutePath
			]

			try {
				def webdriver = DriverFactory.getWebDriver()
				if (webdriver instanceof EventFiringWebDriver) {
					webdriver = ((EventFiringWebDriver) webdriver).getWrappedDriver()
				}
				allArgs["webDriver"] = [
					sessionId: webdriver.getSessionId().toString(),
					serverUrl: DriverFactory.getWebDriverServerUrl(webdriver)
				]
			} catch (BrowserNotOpenedException e) {
			}

			def inputFile = File.createTempFile("ks_py_input_", ".tmp")
			def allArgsJson = groovy.json.JsonOutput.toJson(allArgs)
			KeywordUtil.logInfo(allArgsJson)
			inputFile.write(allArgsJson)

			KeywordUtil.logInfo("Project directory " + RunConfiguration.getProjectDir());
			def pb = new ProcessBuilder(
					"python",
					RunConfiguration.getProjectDir() + "/python/execution.py",
					inputFile.absolutePath)
			def process = pb.start()
			def errCode = process.waitFor()

			def line
			def input = new BufferedReader(new InputStreamReader(process.getInputStream()))
			while ((line = input.readLine()) != null) {
				KeywordUtil.logInfo(line)
			}
			input.close()
		} catch (Exception err) {
			err.printStackTrace()
		}
	}
}