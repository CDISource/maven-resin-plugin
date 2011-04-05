package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal version
 * 
 * @phase process-sources
 */
public class ResinVersionMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/runServer.groovy";
		this.resinRunMode = "version";
		super.execute();
	}
}
