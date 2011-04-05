package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal info
 * 
 * @phase process-sources
 */
public class ResinInfoMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/info.groovy";
		super.execute();
	}
}
