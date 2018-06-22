import cucumber.api.cli.Main as Main

String[] argv = ['-g', '', 'C:\\data\\katalon-projects\\python-test\\Features'].toArray()

ClassLoader contextClassLoader = getClass().getClassLoader()

try {
    Main.run(argv, contextClassLoader)
}
catch (Exception e) {
    e.printStackTrace()
}