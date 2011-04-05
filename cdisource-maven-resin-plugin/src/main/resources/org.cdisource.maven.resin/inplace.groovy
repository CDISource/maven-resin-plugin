plugin.callScript("copyConfig")
plugin.callScript("copyDependencies")

plugin.inplace = true
plugin.runFork = true
plugin.resinRunMode = "gui"
plugin.resinConf = new File(plugin.projectBaseDir, "src/dev/conf/server/in-place.xml")
plugin.callScript("runServer")
