package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal restart
 * 
 * @phase process-sources
 */
public class ResinRestartMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		this.resinRunMode = "restart";
		super.execute();
	}
}
