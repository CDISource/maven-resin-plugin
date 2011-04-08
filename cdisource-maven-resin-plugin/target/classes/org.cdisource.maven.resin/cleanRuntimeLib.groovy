
def ant = new AntBuilder()


if (plugin.runtimeLibDirectory.exists()) {
    println """
    ${plugin.runtimeLibDirectory} exists, deleting it 
    """
    ant.delete(dir:"${plugin.runtimeLibDirectory}")
}