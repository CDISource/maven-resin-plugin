 def ant = new AntBuilder()
 
ant.echo("Running Resin Server")    

println """
ant.java(classname:"com.caucho.boot.ResinBoot", fork:true) {
         arg(value:"${plugin.resinRunMode}")
         if (plugin.resinHelpTopic!=null) {
            arg(value:"${plugin.resinHelpTopic}")
         }
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}
"""

ant.java(classname:"com.caucho.boot.ResinBoot", fork:true) {
         arg(value:"${plugin.resinRunMode}")
         if (plugin.resinHelpTopic!=null) {
            arg(value:"${plugin.resinHelpTopic}")
         }
         classpath() {
           pathelement (location:"${plugin.resinHome}/lib/resin.jar")
         }
}