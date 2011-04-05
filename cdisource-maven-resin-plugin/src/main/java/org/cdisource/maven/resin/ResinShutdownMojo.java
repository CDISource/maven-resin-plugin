package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal shutdown
 * 
 * @phase process-sources
 */
public class ResinShutdownMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		this.resinRunMode = "shutdown";
		super.execute();
	}
}
