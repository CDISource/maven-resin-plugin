def ant = new AntBuilder()

ant.echo("Running Resin Run War")

ant.echo("Copying ./target/${plugin.projectBuildFinalName}.war to ${plugin.resinHome}/webapps/${plugin.warName}.war")
ant.copy(tofile:"${plugin.resinHome}/webapps/${plugin.warName}.war",  file:"./target/${plugin.projectBuildFinalName}.war")
 
plugin.callScript("status") //check the status of the server, is it running?

if (!plugin.resinServerRunning) {
	println ("run resin.fork param ${System.getProperty('resin.fork')}");
	println ("run resin.spawn param ${System.getProperty('resin.spawn')}");

	if (System.getProperty('resin.fork')==null) {
		println ("resin.fork is not set, default is true")
    	plugin.runFork = true
    }
	if (System.getProperty('resin.spawn')==null) {
		println ("resin.spawn is not set, default is false")
    	plugin.runSpawn = false
    }
    if (System.getProperty('resin.runMode')==null) {
		println ("resin.runMode is not set, default is 'gui'")
    	plugin.resinRunMode = 'gui'
    }
    plugin.callScript("runServer")
} else {
    println """
        The server is running already.
    """
}