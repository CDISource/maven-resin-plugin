package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal console
 * 
 * @phase process-sources
 */
public class ResinConsoleMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		this.resinRunMode = "console";
		super.execute();
	}
}
