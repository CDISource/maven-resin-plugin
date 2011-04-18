
//This block is used for development
// To run this for dev go to script folder and run groovy -classpath ../ writeAdminFile.groovy
// The classpath must be set
//if (!this.hasProperty("plugin")) {
//   plugin = [:]
//   plugin.resinHome = new File("/Users/rick/tools/resin/resin-4.0.16/")
//}



def instream = Thread.currentThread().getContextClassLoader().getResourceAsStream("org.cdisource.maven.resin/admin-users.xml")
bytes = instream.getBytes()


File adminOutFile = new File(plugin.resinHome, "conf/admin-users.xml")
adminOutFile.withOutputStream { outStream ->
    outStream.write(bytes)

}

