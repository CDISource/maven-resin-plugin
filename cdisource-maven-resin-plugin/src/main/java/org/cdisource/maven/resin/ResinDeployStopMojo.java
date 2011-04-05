package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal deploy-stop
 * 
 * @phase process-sources
 * @description Stop a deployment
 */
public class ResinDeployStopMojo extends AbstractResinDeployMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "deploy-stop";
		super.execute();
	}
}
