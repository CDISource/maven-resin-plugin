//copy server config

//This block is used for testing, it does not get used in the final product, it is internal
// To run this for dev go to script folder and run groovy -classpath ../ copyServerConfig.groovy
// The classpath must be set
if (!this.hasProperty("plugin")) {
   plugin = [:]
   plugin.resinHome = new File("/Users/rick/tools/resin/resin-4.0.16/")
   plugin.projectBaseDir = new File("/Users/rick/dev/jee6-cdi/samples/trunk/numberguess/")
}

File serverConfDir = new File(plugin.projectBaseDir, "src/dev/conf/server/")

if (!serverConfDir.exists()) {
    serverConfDir.mkdirs();
}

def createFileFromResourceIfDoesNotExist(File serverConfDir, String fileName) {

    File addDefaultXML = new File(serverConfDir, fileName)

    if (!addDefaultXML.exists()) {

        def instream = Thread.currentThread().getContextClassLoader().getResourceAsStream("org.cdisource.maven.resin/${fileName}")
        bytes = instream.getBytes()

        addDefaultXML.withOutputStream { outStream ->
            outStream.write(bytes)
        }
    }

}

createFileFromResourceIfDoesNotExist(serverConfDir, "app-default.xml");
createFileFromResourceIfDoesNotExist(serverConfDir, "in-place.xml");

