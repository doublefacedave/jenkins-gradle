package it.agos.ApagArif.configurations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SingletonConfiguration {
	private String user;
	private String password;
	private String zconnLocalUrl;
	private String zconnContextpath;
	private String zconnUrl;
	private String fuseLocalUrl;
	private String fuseUrl;
	private String fuseContextpath;
	private String version;
	private static SingletonConfiguration instance = null;
	
	private SingletonConfiguration() throws IOException {
		Properties properties = new Properties();
		String propFileName = "application.properties";
		InputStream inputStream;
    	inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		setUser(properties.getProperty("user"));
		setPassword(properties.getProperty("password"));
		setZconnLocalUrl(properties.getProperty("zconnLocalUrl"));
		setZconnContextpath(properties.getProperty("zconnContextpath"));
		setZconnUrl(properties.getProperty("zconnUrl"));
		setFuseLocalUrl(properties.getProperty("fuseLocalUrl"));
		setFuseUrl(properties.getProperty("fuseUrl"));
		setFuseContextpath(properties.getProperty("fuseContextpath"));
		setVersion(properties.getProperty("version"));
	}
	


	public String getUser() {
		return user;
	}
	private void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	
    public String getZconnLocalUrl() {
		return zconnLocalUrl;
	}



    private void setZconnLocalUrl(String zconnLocalUrl) {
		this.zconnLocalUrl = zconnLocalUrl;
	}



	public String getZconnContextpath() {
		return zconnContextpath;
	}



	private void setZconnContextpath(String zconnContextpath) {
		this.zconnContextpath = zconnContextpath;
	}



	public String getZconnUrl() {
		return zconnUrl;
	}



	private void setZconnUrl(String zconnUrl) {
		this.zconnUrl = zconnUrl;
	}



	public String getFuseLocalUrl() {
		return fuseLocalUrl;
	}



	private void setFuseLocalUrl(String fuseLocalUrl) {
		this.fuseLocalUrl = fuseLocalUrl;
	}



	public String getFuseUrl() {
		return fuseUrl;
	}



	private void setFuseUrl(String fuseUrl) {
		this.fuseUrl = fuseUrl;
	}



	public String getFuseContextpath() {
		return fuseContextpath;
	}



	private void setFuseContextpath(String fuseContextpath) {
		this.fuseContextpath = fuseContextpath;
	}



	public String getVersion() {
		return version;
	}



	private void setVersion(String version) {
		this.version = version;
	}



	public static SingletonConfiguration getInstance() throws IOException 
    { 
        if (instance == null) 
            instance = new SingletonConfiguration(); 
  
        return instance; 
    } 
	
}
