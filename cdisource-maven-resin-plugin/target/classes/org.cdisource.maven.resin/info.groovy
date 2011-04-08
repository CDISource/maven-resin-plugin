
println """
Project name projectName: ${plugin.projectName}

Download parameters:
Resin download version (resinVersion):              ${plugin.resinVersion}
Resin download URL Template (dowloadURLTemplate):   ${plugin.resinDowloadURLTemplate}
Resin installPath (installPath):                    ${plugin.resinInstallPath}
Resin resinHome (resinHome):                        ${plugin.resinHome}

Run parameters:
Web XML file location (webXml):                     ${plugin.webXml}
Classes directory (classesDirectory):               ${plugin.classesDirectory}
Test classes directory (testClassesDirectory):      ${plugin.testClassesDirectory}
Web app source diretory (webAppSourceDirectory):    ${plugin.webAppSourceDirectory}
Context Path (contextPath)                          ${plugin.contextPath}
Web Default XML (webDefaultXml)                     ${plugin.webDefaultXml}
System Properties File (systemPropertiesFile)       ${plugin.systemPropertiesFile}
Resin Configuration (resinConf)                     ${plugin.resinConf}
Skip (skip)                                         ${plugin.skip}
Script (script)                                     ${plugin.script}

"""
