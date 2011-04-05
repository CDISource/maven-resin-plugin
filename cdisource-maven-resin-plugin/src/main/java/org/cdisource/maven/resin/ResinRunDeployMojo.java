package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal run-deploy
 * @requiresDependencyResolution runtime
 * @execute phase="package"
 * @description Deploy a war file to resin
 */
public class ResinRunDeployMojo extends AbstractResinDeployMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "deploy";
		super.execute();
	}
}
