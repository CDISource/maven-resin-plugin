package org.cdisource.maven.resin;

/**
 */
public class AbstractResinDeployMojo extends AbstractResinMojo {


	/**	   -address <address>               : ip or host name of the server
	 * 
	 * @parameter expression="${resin.deploy.address}" default-value=""
	 */
	private String resinDeployAddress;
	
	/**-port <port>                     : server http port
	 * @parameter expression="${resin.deploy.port}" default-value=""
	 */
	private String resinDeployPort;
	
	/**   -user <user>                     : user name used for authentication to the server
	 * @parameter expression="${resin.deploy.user}" default-value="dev"
	 */
	private String resinDeployUser;

	/** 
	 *   -password <password>             : password used for authentication to the server
	 * 	@parameter expression="${resin.deploy.password}" default-value="dev"
	 */
	private String resinDeployPassword;
	
	/** -source <source>                 : source context
	 * 	@parameter expression="${resin.deploy.source}" default-value=""
	*/
	private String resinDeploySource;
	
	/**   -source-host <source-host>       : source host
	 * 	@parameter expression="${resin.deploy.sourceHost}" default-value=""
	*/
	private String resinDeploySourceHost;
	
	/**-source-stage <source-stage>     : source stage
	 * 	@parameter expression="${resin.deploy.sourceStage}" default-value=""
	*/
	private String resinDeploySourceStage;
	
	/**-source-version <source-version> : source version
	 * 	@parameter expression="${resin.deploy.sourceVersion}" default-value=""
	*/
	private String resinDeploySourceVersion;
	
	/**    -target <target>                 : target context
	 * @parameter expression="${resin.deploy.target}" default-value=""
	*/
	private String resinDeployTarget;
	
	/**   -target-host <target-host>       : target host
	 * @parameter expression="${resin.deploy.targetHost}" default-value=""
	*/
	private String resinDeployTargetHost;

	/**   -target-stage <target-stage>     : target stage
	 * @parameter expression="${resin.deploy.targetStage}" default-value=""
	*/
	private String resinDeployTargetStage;

	/**   -target-version <target-version> : target version
	 * @parameter expression="${resin.deploy.version}" default-value=""
	*/
	private String resinDeployTargetVersion;

	/**
	 *    -m <message>          : commit message
	 * @parameter expression="${resin.deploy.message}" default-value=""
	 */
	private String resinDeployMessage;

	public String getResinDeployAddress() {
		return resinDeployAddress;
	}

	public void setResinDeployAddress(String resinDeployAddress) {
		this.resinDeployAddress = resinDeployAddress;
	}

	public String getResinDeployPort() {
		return resinDeployPort;
	}

	public void setResinDeployPort(String resinDeployPort) {
		this.resinDeployPort = resinDeployPort;
	}

	public String getResinDeployUser() {
		return resinDeployUser;
	}

	public void setResinDeployUser(String resinDeployUser) {
		this.resinDeployUser = resinDeployUser;
	}

	public String getResinDeployPassword() {
		return resinDeployPassword;
	}

	public void setResinDeployPassword(String resinDeployPassword) {
		this.resinDeployPassword = resinDeployPassword;
	}

	public String getResinDeploySource() {
		return resinDeploySource;
	}

	public void setResinDeploySource(String resinDeploySource) {
		this.resinDeploySource = resinDeploySource;
	}

	public String getResinDeploySourceHost() {
		return resinDeploySourceHost;
	}

	public void setResinDeploySourceHost(String resinDeploySourceHost) {
		this.resinDeploySourceHost = resinDeploySourceHost;
	}

	public String getResinDeploySourceStage() {
		return resinDeploySourceStage;
	}

	public void setResinDeploySourceStage(String resinDeploySourceStage) {
		this.resinDeploySourceStage = resinDeploySourceStage;
	}

	public String getResinDeploySourceVersion() {
		return resinDeploySourceVersion;
	}

	public void setResinDeploySourceVersion(String resinDeploySourceVersion) {
		this.resinDeploySourceVersion = resinDeploySourceVersion;
	}

	public String getResinDeployTarget() {
		return resinDeployTarget;
	}

	public void setResinDeployTarget(String resinDeployTarget) {
		this.resinDeployTarget = resinDeployTarget;
	}

	public String getResinDeployTargetHost() {
		return resinDeployTargetHost;
	}

	public void setResinDeployTargetHost(String resinDeployTargetHost) {
		this.resinDeployTargetHost = resinDeployTargetHost;
	}

	public String getResinDeployTargetStage() {
		return resinDeployTargetStage;
	}

	public void setResinDeployTargetStage(String resinDeployTargetStage) {
		this.resinDeployTargetStage = resinDeployTargetStage;
	}

	
	public String getResinDeployTargetVersion() {
		return resinDeployTargetVersion;
	}

	public void setResinDeployTargetVersion(String resinDeployTargetVersion) {
		this.resinDeployTargetVersion = resinDeployTargetVersion;
	}

	public String getResinDeployMessage() {
		return resinDeployMessage;
	}

	public void setResinDeployMessage(String resinDeployMessage) {
		this.resinDeployMessage = resinDeployMessage;
	}
	
	
}
