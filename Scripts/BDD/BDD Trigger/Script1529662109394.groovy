import static groovy.io.FileType.FILES

import org.codehaus.groovy.control.CompilerConfiguration

import com.kms.katalon.core.configuration.RunConfiguration

import cucumber.api.cli.Main as Main

def root = RunConfiguration.getProjectDir()

String[] argv = ['-g', '', root + "/Features"].toArray()

try {
    Main.run(argv, getClass().getClassLoader())
}
catch (Exception e) {
    e.printStackTrace()
} 

