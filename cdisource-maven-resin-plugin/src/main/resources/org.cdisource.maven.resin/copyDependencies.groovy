import org.apache.maven.model.Dependency



if (plugin.runtimeLibDirectory.exists()) {
    println """
    ${plugin.runtimeLibDirectory} already exists!! 
    dependencies will not be copied over to ${plugin.runtimeLibDirectory}
    """
} else {
    processDependencies()
}


def copyJarToRuntimeLib(File dir, File file, ant) {
    println """copying ${file} to ${plugin.runtimeLibDirectory}
            """
    ant.copy(todir:"${plugin.runtimeLibDirectory}") {

        fileset(dir:"${dir}") {
                include(name:"${file.name}")
        }
    }
}

def processDependencies() {
    if (!plugin.mavenLocalRepoDirectory) {
        plugin.mavenLocalRepoDirectory = new File (System.getProperty("user.home"), ".m2/repository")
    }

    List<Dependency> dependencies = plugin.project.dependencies
    
    def ant = new AntBuilder()
    

    for (Dependency dependency : dependencies) {
        if (dependency.scope.equals("compile") && dependency.type.equals("jar")) {
            File groupDir = new File(plugin.mavenLocalRepoDirectory, dependency.groupId.replace(".","/"))
            File artifactDir = new File(groupDir, dependency.artifactId)
            File versionDir = new File(artifactDir, dependency.version)
            
            def jarPattern = ~/.*\.jar/
            versionDir.eachFileMatch(jarPattern) {file ->
                copyJarToRuntimeLib(versionDir, file, ant)
            }
        }
    }
}