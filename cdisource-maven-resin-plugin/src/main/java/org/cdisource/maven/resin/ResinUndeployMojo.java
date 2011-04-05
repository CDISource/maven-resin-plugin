package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal undeploy
 * @requiresDependencyResolution runtime
 * @execute phase="package"
 * @description Undeploy a war file
 */
public class ResinUndeployMojo extends AbstractResinDeployMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "undeploy";
		super.execute();
	}
}
