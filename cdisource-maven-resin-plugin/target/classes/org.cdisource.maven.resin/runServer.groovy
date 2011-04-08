def ant = new AntBuilder()
 
// lets just call one task
ant.echo("Running Resin Server")    

if (plugin.resinVerbose) {
    println """

ant.java(classname:"com.caucho.boot.ResinBoot", fork:"${plugin.runFork}", spawn:"${plugin.runSpawn}") {
         arg(value:"${plugin.resinRunMode}")
         
         if (plugin.inplace) {
            sysproperty (key:"resin.server.home", value:"${plugin.resinHome}")
            sysproperty (key:"resin.server.address", value:"${plugin.resinAddress}")
            sysproperty (key:"resin.server.port", value:"${plugin.resinPort}")
            sysproperty (key:"resin.webapp.context", value:"${plugin.contextPath}")
            sysproperty (key:"resin.webapp.dir", value:"${plugin.projectBuildDir}/${plugin.projectBuildFinalName}")
            sysproperty (key:"resin.project.basedir", value:"${plugin.projectBaseDir}")
            sysproperty (key:"resin.webapp.sourcedirectory", value:"${plugin.webAppSourceDirectory}")
            sysproperty (key:"resin.java.sourcedirectory", value:"${plugin.javaSourceDirectory}")
            sysproperty (key:"resin.webapp.runtimelib", value:"${plugin.runtimeLibDirectory}")
            
            
         }
         if (plugin.resinHome) {
            arg(value:"-resin-home")
            arg(value:"${plugin.resinHome}")
         }
         if (plugin.resinServer) {
            arg(value:"-server")
            arg(value:"${plugin.resinServer}")
         }         
         if (plugin.resinDynamicServer) {
            arg(value:"-dynamic-server")
            arg(value:"${plugin.resinDynamicServer}")
         }         
         if (plugin.resinLogDirectory) {
            arg(value:"-log-directory")
            arg(value:"${plugin.resinLogDirectory}")
         }         
         if (plugin.resinRootDirectory) {
            arg(value:"-root-directory")
            arg(value:"${plugin.resinRootDirectory}")
         }         
         if (plugin.resinWatchdogPort) {
            arg(value:"-watchdog-port")
            arg(value:"${plugin.resinWatchdogPort}")
         }         
         if (plugin.resinPreview) {
            arg(value:"-preview")
            arg(value:"${plugin.resinPreview}")
         }         
         if (plugin.resinDebugPort) {
            arg(value:"-debug-port")
            arg(value:"${plugin.resinDebugPort}")
         }         
         if (plugin.resinJmxPort) {
            arg(value:"-jmx-port")
            arg(value:"${plugin.resinJmxPort}")
         }         
         if (plugin.resinVerbose) {
            arg(value:"-verbose")
            arg(value:"${plugin.resinVerbose}")
         }         
         if (plugin.resinConf) {
            arg(value:"-conf")
            arg(value:"${plugin.resinConf}")
         }
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
} 
    """
}

ant.java(classname:"com.caucho.boot.ResinBoot", fork:"${plugin.runFork}", spawn:"${plugin.runSpawn}") {
         arg(value:"${plugin.resinRunMode}")
         if (plugin.inplace) {
            sysproperty (key:"resin.server.home", value:"${plugin.resinHome}")
            sysproperty (key:"resin.server.address", value:"${plugin.resinAddress}")
            sysproperty (key:"resin.server.port", value:"${plugin.resinPort}")
            sysproperty (key:"resin.webapp.context", value:"${plugin.contextPath}")
            sysproperty (key:"resin.webapp.dir", value:"${plugin.projectBuildDir}/${plugin.projectBuildFinalName}")
            sysproperty (key:"resin.project.basedir", value:"${plugin.projectBaseDir}")
            sysproperty (key:"resin.webapp.sourcedirectory", value:"${plugin.webAppSourceDirectory}")
            sysproperty (key:"resin.java.sourcedirectory", value:"${plugin.javaSourceDirectory}")
            sysproperty (key:"resin.webapp.runtimelib", value:"${plugin.runtimeLibDirectory}")
            
            
         }
         
         if (plugin.resinHome) {
            arg(value:"-resin-home")
            arg(value:"${plugin.resinHome}")
         }
         if (plugin.resinServer) {
            arg(value:"-server")
            arg(value:"${plugin.resinServer}")
         }         
         if (plugin.resinDynamicServer) {
            arg(value:"-dynamic-server")
            arg(value:"${plugin.resinDynamicServer}")
         }         
         if (plugin.resinLogDirectory) {
            arg(value:"-log-directory")
            arg(value:"${plugin.resinLogDirectory}")
         }         
         if (plugin.resinRootDirectory) {
            arg(value:"-root-directory")
            arg(value:"${plugin.resinRootDirectory}")
         }         
         if (plugin.resinWatchdogPort) {
            arg(value:"-watchdog-port")
            arg(value:"${plugin.resinWatchdogPort}")
         }         
         if (plugin.resinPreview) {
            arg(value:"-preview")
            arg(value:"${plugin.resinPreview}")
         }         
         if (plugin.resinDebugPort) {
            arg(value:"-debug-port")
            arg(value:"${plugin.resinDebugPort}")
         }         
         if (plugin.resinJmxPort) {
            arg(value:"-jmx-port")
            arg(value:"${plugin.resinJmxPort}")
         }
         if (plugin.resinVerbose) {
            arg(value:"-verbose")
            arg(value:"${plugin.resinVerbose}")
         }         
         if (plugin.resinConf) {
            arg(value:"-conf")
            arg(value:"${plugin.resinConf}")
         }
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}