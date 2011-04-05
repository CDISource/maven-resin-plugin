


println """
Project name projectName: ${plugin.projectName}

Download parameters:
Resin download version (resinVersion):                   ${plugin.resinVersion}
Resin download URL Template (resinDowloadURLTemplate):   ${plugin.resinDowloadURLTemplate}
Resin installPath (resinInstallPath):                    ${plugin.resinInstallPath}
Resin Offline (resinOffline):                            ${plugin.resinOffline}

"""

def ant = new AntBuilder()


def urlToDownload = plugin.resinDowloadURLTemplate.replace("VERSION", plugin.resinVersion)
println "About to download $urlToDownload to ${plugin.tmpDirectory}, this could take a while, be patient..."



if (!plugin.tmpDirectory.exists()) {
    println "temp dir does not exist creating"
    plugin.tmpDirectory.mkdirs()
}

if (!plugin.resinOffline) {
    ant.get(src:urlToDownload, dest:"${plugin.tmpDirectory}/resin-${plugin.resinVersion}.zip", verbose:plugin.resinVerbose)
} else {
    println "Offline mode not fetching  $urlToDownload to ${plugin.tmpDirectory}"
}


println """
ant.unzip(src:"${plugin.tmpDirectory}/resin-${plugin.resinVersion}.zip", 
          dest:"${plugin.tmpDirectory}/")
"""

ant.unzip(src:"${plugin.tmpDirectory}/resin-${plugin.resinVersion}.zip", dest:"${plugin.tmpDirectory}")
 
 //Make resin root if it does not exist
File home = new File(System.getProperty("user.home"));
File resinRoot = new File(home, "tools/resin");
if (!resinRoot.exists()) {
    resinRoot.mkdirs()
}
 
println "About to expand to $resinRoot"

println """
ant.move(todir:"$resinRoot/resin-${plugin.resinVersion}") {
        fileset(dir:"${plugin.tmpDirectory}/resin-${plugin.resinVersion}") {
        }
 }
"""


ant.move(todir:"$resinRoot/resin-${plugin.resinVersion}") {
        fileset(dir:"${plugin.tmpDirectory}/resin-${plugin.resinVersion}") {
        }
 }
 
plugin.callScript("processResinConfigFile")
plugin.callScript("writeAdminFile")
 