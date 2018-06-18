package demo
import com.kms.katalon.core.annotation.Keyword


class PythonKeywords {

	@Keyword
	def helloWorld(int a, int b) {
		runPython("keywords.helloWorld", a, b)
	}

	private runPython(String script, Object[] keywordArgs) {
		try {
			System.out.println(keywordArgs)
			def outputFile = File.createTempFile("ks_py_output_", ".tmp")
			System.out.println(outputFile.absolutePath)
			def allArgs = [
				keyword: script,
				keywordArgs: keywordArgs,
				outputPath: outputFile.absolutePath,
				context: [
					sessionId: "f2e1e7e938875ed363f1b65dd445d37a",
					commandUrl: "http://127.0.0.1:55324"
				]
			]
			def inputFile = File.createTempFile("ks_py_input_", ".tmp")
			def allArgsJson = groovy.json.JsonOutput.toJson(allArgs)
			System.out.println(keywordArgs)
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
				System.out.println(line)
			}
			input.close()
		} catch (Exception err) {
			err.printStackTrace()
		}
	}
}