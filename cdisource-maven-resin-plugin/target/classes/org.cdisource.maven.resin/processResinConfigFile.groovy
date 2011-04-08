
if (!this.hasProperty("plugin")) {
   plugin = [:]
   plugin.resinHome = new File("/Users/rick/tools/resin/resin-4.0.16/")

}

def resinXML = new File(plugin.resinHome, "conf/resin.xml")
println resinXML

def ant = new AntBuilder()

def backUpResinXML = "${resinXML}.bak.${System.currentTimeMillis()}"
println "About to back up ${resinXML} to ${backUpResinXML}" 
ant.copy(file:"${resinXML}", tofile:"${backUpResinXML}")



def lines = resinXML.readLines()

// Or a writer object:
resinXML.withWriter('UTF-8') { writer ->
    writer.println("""<!-- This file has been modified by the maven plugin for resin. 
    			   You are welcome. :P Rick -->""")
    for (line in lines) {
    	if (line.contains("""<resin:set var="resin_admin_external" value="false"/>""")) {
	   writer.println (""" 
	   <!-- This line was added by the maven plugin to turn on admin functions. -->
	    <resin:set var="resin_admin_external" value="true"/>
		   """
		   )
	} else if (line.contains("""<cluster id="app-tier">""")) {
	   writer.println("""
  <cluster id="app-tier">
    <!-- Maven plugin added this two lines so that we can use deploy command. -->
    <resin:RemoteAdminService/>
    <resin:DeployService/>
	   
	   """)
	   
	}
	else {
    	  writer.println(line)
	}
    }
}