package org.cdisource.maven.resin;

import org.apache.maven.plugin.MojoExecutionException;

/**
 * @goal help
 * 
 * @phase process-sources
 */
public class ResinHelpMojo extends AbstractResinMojo {
	/**
	 * @parameter expression="${resin.help.topic}"
	 *            default-value=""
	 * @parameter
	 */
	protected String resinHelpTopic;
	
	public void execute() throws MojoExecutionException {
		this.script = "org.cdisource.maven.resin/help.groovy";
		this.resinRunMode = "help";
		super.execute();
	}

	public String getResinHelpTopic() {
		return resinHelpTopic;
	}

	public void setResinHelpTopic(String resinHelpTopic) {
		this.resinHelpTopic = resinHelpTopic;
	}
	
	
}
