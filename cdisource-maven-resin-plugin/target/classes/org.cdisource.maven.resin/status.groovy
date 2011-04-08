def ant = new AntBuilder()
 
// lets just call one task
ant.echo("Running Resin Status")    

if (plugin.resinVerbose) {
    println """

ant.java(classname:"com.caucho.boot.ResinBoot", fork:true, outputproperty:"runJavaOutput", timeout:"3000") {
         arg(value:"status")
         
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
         
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}

"""
}

ant.java(classname:"com.caucho.boot.ResinBoot", fork:true, outputproperty:"runJavaOutput", timeout:"3000") {
         arg(value:"status")

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

         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}

def output = ant.project.getProperty("runJavaOutput")
if (output.contains("java.net.ConnectException: Connection refused")) {
    plugin.resinServerRunning = false
    println "STATUS The server is not running"
} else {
    plugin.resinServerRunning = true
    println output
}