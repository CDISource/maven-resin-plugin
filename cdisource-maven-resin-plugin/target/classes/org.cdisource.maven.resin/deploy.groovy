def ant = new AntBuilder()
 
ant.echo("Running Deploy Goal: ${plugin.resinRunMode}")

if (plugin.resinVerbose) println "checking status of server"
plugin.callScript("status") //check the status of the server, is it running?

if (!plugin.resinServerRunning) {
    if (plugin.resinVerbose) println "The server was not running so we are starting it"
    plugin.runFork = true
    plugin.runSpawn = true
    plugin.runServerScript("runServer", "restart")
} else {
    println """
        The server is running already.
    """
}    


if (plugin.resinVerbose) println """
Waiting for http://localhost:8080/resin-doc/ to become available, check every 2 seconds for 30 seconds
"""

ant.waitfor(maxwait:"30", maxwaitunit:"second", checkevery:"2000") {
        http (url:"http://localhost:8080/resin-doc/")
}

if (plugin.resinVerbose) {
    println """
    ant.java(classname:"com.caucho.boot.ResinBoot", fork:true) {
         arg(value:"${plugin.resinRunMode}")
         if (plugin.resinDeployAddress) {
            arg(value:"-address")
            arg(value:"${plugin.resinDeployAddress}")
         }
         if (plugin.resinDeployPort) {
            arg(value:"-port")
            arg(value:"${plugin.resinDeployPort}")
         }         
         if (plugin.resinDeployUser) {
            arg(value:"-user")
            arg(value:"${plugin.resinDeployUser}")
         }         
         if (plugin.resinDeployPassword) {
            arg(value:"-password")
            arg(value:"${plugin.resinDeployPassword}")
         }         
         if (plugin.resinDeploySource) {
            arg(value:"-source")
            arg(value:"${plugin.resinDeploySource}")
         }         
         if (plugin.resinDeploySourceHost) {
            arg(value:"-source-host")
            arg(value:"${plugin.resinDeploySourceHost}")
         }         
         if (plugin.resinDeploySourceStage) {
            arg(value:"-source-stage")
            arg(value:"${plugin.resinDeploySourceStage}")
         }         
         if (plugin.resinDeploySourceVersion) {
            arg(value:"-source-version")
            arg(value:"${plugin.resinDeploySourceVersion}")
         }         
         if (plugin.resinDeployTarget) {
            arg(value:"-target")
            arg(value:"${plugin.resinDeployTarget}")
         }
         if (plugin.resinDeployTargetHost) {
            arg(value:"-target-host")
            arg(value:"${plugin.resinDeployTargetHost}")
         }         


         if (plugin.resinDeployTargetStage) {
            arg(value:"-target-stage")
            arg(value:"${plugin.resinDeployTargetStage}")
         }         

         if (plugin.resinDeployTargetVersion) {
            arg(value:"-target-version")
            arg(value:"${plugin.resinDeployTargetVersion}")
         }         

         if (plugin.resinDeployMessage) {
            arg(value:"-m")
            arg(value:"${plugin.resinDeployMessage}")
         }         
         if (plugin.warName.equals(plugin.project.artifactId)) {         
            arg(value:"./target/${plugin.warName}-${plugin.project.version}.war")
         } else {
            arg(value:"./target/${plugin.warName}.war")
         }
         
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}
} 
"""
}


ant.java(classname:"com.caucho.boot.ResinBoot", fork:true) {
         arg(value:"${plugin.resinRunMode}")
         if (plugin.resinDeployAddress) {
            arg(value:"-address")
            arg(value:"${plugin.resinDeployAddress}")
         }
         if (plugin.resinDeployPort) {
            arg(value:"-port")
            arg(value:"${plugin.resinDeployPort}")
         }         
         if (plugin.resinDeployUser) {
            arg(value:"-user")
            arg(value:"${plugin.resinDeployUser}")
         }         
         if (plugin.resinDeployPassword) {
            arg(value:"-password")
            arg(value:"${plugin.resinDeployPassword}")
         }         
         if (plugin.resinDeploySource) {
            arg(value:"-source")
            arg(value:"${plugin.resinDeploySource}")
         }         
         if (plugin.resinDeploySourceHost) {
            arg(value:"-source-host")
            arg(value:"${plugin.resinDeploySourceHost}")
         }         
         if (plugin.resinDeploySourceStage) {
            arg(value:"-source-stage")
            arg(value:"${plugin.resinDeploySourceStage}")
         }         
         if (plugin.resinDeploySourceVersion) {
            arg(value:"-source-version")
            arg(value:"${plugin.resinDeploySourceVersion}")
         }         
         if (plugin.resinDeployTarget) {
            arg(value:"-target")
            arg(value:"${plugin.resinDeployTarget}")
         }
         if (plugin.resinDeployTargetHost) {
            arg(value:"-target-host")
            arg(value:"${plugin.resinDeployTargetHost}")
         }         


         if (plugin.resinDeployTargetStage) {
            arg(value:"-target-stage")
            arg(value:"${plugin.resinDeployTargetStage}")
         }         

         if (plugin.resinDeployTargetVersion) {
            arg(value:"-target-version")
            arg(value:"${plugin.resinDeployTargetVersion}")
         }         

         if (plugin.resinDeployMessage) {
            arg(value:"-m")
            arg(value:"${plugin.resinDeployMessage}")
         }
         if (plugin.warName.equals(plugin.project.artifactId)) {         
            arg(value:"./target/${plugin.warName}-${plugin.project.version}.war")
         } else {
            arg(value:"./target/${plugin.warName}.war")
         }
         
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}