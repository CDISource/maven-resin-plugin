package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal start
 * 
 * @phase process-sources
 */
public class ResinStartMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		this.resinRunMode = "start";
		super.execute();
	}
}
