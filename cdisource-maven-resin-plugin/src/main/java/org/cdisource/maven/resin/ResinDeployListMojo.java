package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal deploy-list
 * 
 * @phase process-sources
 * @description Show a list of deployments on the server
 */
public class ResinDeployListMojo extends AbstractResinDeployMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "deploy-list";
		super.execute();
	}
}
