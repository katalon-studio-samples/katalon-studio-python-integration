package demo
import com.kms.katalon.core.annotation.Keyword
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
	
	@Keyword
	def runRobot() {
		runPython("keywords.run_robot")
	}

	private runPython(String script, Object[] keywordArgs) {
		try {
			System.out.println(keywordArgs)
			def outputFile = File.createTempFile("ks_py_output_", ".tmp")
			System.out.println(outputFile.absolutePath)

			def allArgs = [
				keyword: script,
				keywordArgs: keywordArgs,
				outputPath: outputFile.absolutePath
			]

			try {
				def webdriver = DriverFactory.getWebDriver()
				allArgs["webDriver"] = [
					sessionId: webdriver.getSessionId().toString(),
					serverUrl: DriverFactory.getWebDriverServerUrl(webdriver)
				]
			} catch (BrowserNotOpenedException e) {
			}

			def inputFile = File.createTempFile("ks_py_input_", ".tmp")
			def allArgsJson = groovy.json.JsonOutput.toJson(allArgs)
			System.out.println(allArgsJson)
			inputFile.write(allArgsJson)

			def pb = new ProcessBuilder(
					"python",
					"c:/data/python-server/execution.py",
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