def ant = new AntBuilder()

ant.echo("Running Resin Run War")

ant.echo("Copying ./target/${plugin.warName}.war to ${plugin.resinHome}/webapps")
ant.copy(todir:"${plugin.resinHome}/webapps") {
        fileset(dir:"./target/") {
                include(name:"${plugin.warName}*.war")
        }
}

plugin.callScript("status") //check the status of the server, is it running?

if (!plugin.resinServerRunning) {
    plugin.runFork = true
    plugin.runSpawn = true
    plugin.callScript("runServer")
} else {
    println """
        The server is running already.
    """
}