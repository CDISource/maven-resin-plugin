package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal run-war
 * @requiresDependencyResolution runtime
 * @execute phase="package"
 * @description Run Resin on a war file
 */
public class ResinRunWarMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		if (this.getResinRunMode().equals("version")) {
			this.setResinRunMode("restart");
		}
		this.script = "org.cdisource.maven.resin/runWar.groovy";
		super.execute();
	}
}
