package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal deploy-restart
 * 
 * @phase process-sources
 * @description Restart a deployment
 */
public class ResinDeployRestartMojo extends AbstractResinDeployMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "deploy-restart";
		super.execute();
	}
}
