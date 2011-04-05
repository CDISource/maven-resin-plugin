package org.cdisource.maven.resin;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal run-inplace
 * 
 * @requiresDependencyResolution runtime
 * @execute phase="package"
 * @description Run Resin in place
 */
public class ResinRunInPlaceMojo extends AbstractResinMojo {

	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/inplace.groovy";
		super.execute();
	}
}
