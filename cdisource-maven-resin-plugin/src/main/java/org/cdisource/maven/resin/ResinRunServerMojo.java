package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal run-server
 * 
 * @phase process-sources
 */
public class ResinRunServerMojo extends AbstractResinMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		super.execute();
	}
}
