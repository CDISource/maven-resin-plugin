package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;


/**
 * 
 * @goal install
 * 
 * @phase process-sources
 */
public class ResinInstallMojo extends AbstractResinMojo {
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/install.groovy";
		super.execute();
	}
}
