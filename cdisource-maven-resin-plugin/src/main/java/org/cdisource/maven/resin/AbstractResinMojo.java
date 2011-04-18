package org.cdisource.maven.resin;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.cdisource.maven.webrunner.AbstractWebRunnerMojo;

/**
 * AbstractResinMojo
 * 
 * 
 */
public abstract class AbstractResinMojo extends AbstractWebRunnerMojo {
	
	private boolean resinServerRunning;
	
	private boolean inplace;

	/**
	 * The resin version that we will download and install.
	 * 
	 * @parameter expression="${resin.version}" default-value="4.0.17"
	 * @required
	 */
	protected String resinVersion;

	/**
	 * The resin version that we will download and install.
	 * 
	 * @parameter expression="${resin.downloadURLTemplate}"
	 *            default-value="http://www.caucho.com/download/resin-VERSION.zip"
	 * @required
	 */
	protected String resinDowloadURLTemplate;

	/**
	 * Location to install Resin.
	 * 
	 * @parameter expression="${resin.installPath}"
	 *            default-value="${user.home}/tools/resin/resin-VERSION"
	 */
	protected String resinInstallPath;

	/**
	 * Resin home dir.
	 * 
	 * @parameter expression="${resin.home}"
	 *            default-value=""
	 */
	protected String resinHome;
	

	/**
	 * Resin verbose.
	 * 
	 * @parameter expression="${resin.verbose}"
	 *            default-value="false"
	 */
	protected boolean resinVerbose;

	/**
	 * Resin offline.
	 * 
	 * @parameter expression="${resin.offline}"
	 *            default-value="false"
	 */
	protected boolean resinOffline;

	
	/**
	 * Location of a resin xml configuration file. 
	 * Optional.
	 * 
	 * @parameter
	 */
	protected File resinConf;

	/**
	 * What do you want to do with Resin?
	 * Must be set to:
	 * console | status | start | gui | stop | restart | kill | shutdown | version
	 * @parameter expression="${resin.runMode}"
	 *            default-value="version"
	 */
	protected String resinRunMode;
	
	/**
	 * 	   -server <id>          : select a <server> to run
	 * @parameter expression="${resin.server}" default-value=""
	 */
	protected String resinServer;
	
	/**
	 * -dynamic-server <cluster:address:port> : initialize a dynamic server
	 * @parameter expression="${resin.dynamicServer}" default-value=""
	 */
	protected String resinDynamicServer;
	
	/**
	 *  -log-directory <dir>  : select a logging directory
	 * @parameter expression="${resin.logDirectory}" default-value=""
	 */
	protected File resinLogDirectory;

	
	/**
	 * 	   -root-directory <dir> : select a root directory
	 * @parameter expression="${resin.rootDirectory}" default-value=""
	 */
	protected File resinRootDirectory;
	

	/**
	 * 	   -watchdog-port <port> : override the watchdog-port
	 * @parameter expression="${resin.watchdogPort}" default-value=""
	 */
	protected String resinWatchdogPort;

	/**
	   -preview              : run as a preview server
	 * @parameter expression="${resin.preview}" default-value=""
	 */
	protected String resinPreview;

	/**
	   -debug-port <port>    : configure a debug port
	 * @parameter expression="${resin.debugPort}" default-value="8000"
	 */
	protected String resinDebugPort;

	/**
	   -jmx-port <port>      : configure an unauthenticated jmx port
	 * @parameter expression="${resin.jmxPort}" default-value="16789"
	 */
	protected String resinJmxPort;
	
	/**
	 * @parameter expression="${resin.port}" default-value="9090"
	 */
	protected String resinPort;

	/**
	 * @parameter expression="${resin.address}" default-value="localhost"
	 */
	protected String resinAddress;

	
	
	public void runServerScript(String script, String resinRunMode) throws MojoExecutionException {
		String old = this.resinRunMode;
		this.resinRunMode = resinRunMode;
		callScript(script);
		this.resinRunMode = old;
	}
	
	/*
	*/
	public void execute() throws MojoExecutionException {
		

		
		if (skip) {
			getLog().info("Skipping resin: resin.skip==true");
			return;
		}

		super.prepareForExecute();
		
		
		if (this.resinHome==null || "".equals(this.resinHome.trim())) {
			resinHome = this.resinInstallPath.replace("VERSION", this.getResinVersion());
		}
		
		File resinJar = new File(this.resinHome, "lib/resin.jar");
		if (!resinJar.exists()) {
			runScript("org.cdisource.maven.resin/install.groovy");
		}

		runScript(script);

	}

	public boolean isResinServerRunning() {
		return resinServerRunning;
	}

	public void setResinServerRunning(boolean resinServerRunning) {
		this.resinServerRunning = resinServerRunning;
	}

	
	public String getResinServer() {
		return resinServer;
	}


	public void setResinServer(String resinServer) {
		this.resinServer = resinServer;
	}


	public File getResinLogDirectory() {
		return resinLogDirectory;
	}


	public void setResinLogDirectory(File resinLogDirectory) {
		this.resinLogDirectory = resinLogDirectory;
	}


	public File getResinRootDirectory() {
		return resinRootDirectory;
	}


	public void setResinRootDirectory(File resinRootDirectory) {
		this.resinRootDirectory = resinRootDirectory;
	}


	public String getResinWatchdogPort() {
		return resinWatchdogPort;
	}


	public void setResinWatchdogPort(String resinWatchdogPort) {
		this.resinWatchdogPort = resinWatchdogPort;
	}


	public String getResinPreview() {
		return resinPreview;
	}


	public void setResinPreview(String resinPreview) {
		this.resinPreview = resinPreview;
	}


	public String getResinDebugPort() {
		return resinDebugPort;
	}


	public void setResinDebugPort(String resinDebugPort) {
		this.resinDebugPort = resinDebugPort;
	}


	public String getResinJmxPort() {
		return resinJmxPort;
	}


	public void setResinJmxPort(String resinJmxPort) {
		this.resinJmxPort = resinJmxPort;
	}


	public String getResinDynamicServer() {
		return resinDynamicServer;
	}


	public void setResinDynamicServer(String resinDynamicServer) {
		this.resinDynamicServer = resinDynamicServer;
	}




	
	public boolean isResinVerbose() {
		return resinVerbose;
	}


	public void setResinVerbose(boolean resinVerbose) {
		this.resinVerbose = resinVerbose;
	}


	public boolean isResinOffline() {
		return resinOffline;
	}


	public void setResinOffline(boolean resinOffline) {
		this.resinOffline = resinOffline;
	}


	public String getResinHome() {
		return resinHome;
	}

	public void setResinHome(String resinHome) {
		this.resinHome = resinHome;
	}

	public String getResinRunMode() {
		return resinRunMode;
	}

	public void setResinRunMode(String resinRunMode) {
		this.resinRunMode = resinRunMode;
	}

	public String getResinVersion() {
		return resinVersion;
	}

	public void setResinVersion(String resinVersion) {
		this.resinVersion = resinVersion;
	}


	public String getResinDowloadURLTemplate() {
		return resinDowloadURLTemplate;
	}


	public void setResinDowloadURLTemplate(String resinDowloadURLTemplate) {
		this.resinDowloadURLTemplate = resinDowloadURLTemplate;
	}


	public String getResinInstallPath() {
		return resinInstallPath;
	}


	public void setResinInstallPath(String resinInstallPath) {
		this.resinInstallPath = resinInstallPath;
	}


	public File getResinConf() {
		return resinConf;
	}

	public void setResinConf(File resinConf) {
		this.resinConf = resinConf;
	}

	public boolean isInplace() {
		return inplace;
	}

	public void setInplace(boolean inplace) {
		this.inplace = inplace;
	}
	
	

}
