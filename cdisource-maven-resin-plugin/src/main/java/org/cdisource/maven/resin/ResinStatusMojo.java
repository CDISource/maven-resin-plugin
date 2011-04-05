package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal status
 * 
 * @phase process-sources
 */
public class ResinStatusMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/status.groovy";
		this.resinRunMode = "status";
		super.execute();
	}
}
