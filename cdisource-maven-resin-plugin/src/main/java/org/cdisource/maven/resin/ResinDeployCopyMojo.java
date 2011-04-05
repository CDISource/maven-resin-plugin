package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal deploy-copy
 * @requiresDependencyResolution runtime
 * @execute phase="package"
 * @description Copy a deployed war file to another resin instance
 */
public class ResinDeployCopyMojo extends AbstractResinMojo {

	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/deploy.groovy";
		this.resinRunMode = "deploy-copy";
		super.execute();
	}
}
