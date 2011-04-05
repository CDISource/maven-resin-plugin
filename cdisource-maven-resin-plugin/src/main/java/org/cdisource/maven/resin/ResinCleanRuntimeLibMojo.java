package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal clean-runtimelib
 * 
 * @phase process-sources
 */
public class ResinCleanRuntimeLibMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/cleanRuntimeLib.groovy";
		super.execute();
	}
}
