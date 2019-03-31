package com.crawlyfi.lib.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

public class Service {

	private Properties properties = new Properties();
	private String[] messageBrokerSettings = new String[4];

	public Service(){
		readProperties();
		setMessageBrokerSettings();
	}
	
	protected  void readProperties() {
		String resourceName = "config.properties"; // could also be a constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			properties.load(resourceStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void setMessageBrokerSettings(){
		messageBrokerSettings[0] = properties.getProperty("rabbitHost"); 
		messageBrokerSettings[1] = properties.getProperty("rabbitPort"); 
		messageBrokerSettings[2] = properties.getProperty("rabbitUser"); 
		messageBrokerSettings[3] = properties.getProperty("rabbitPassword");
	}

	public void printProperties(){
		StringWriter writer = new StringWriter();
		getProperties().list(new PrintWriter(writer));
		System.out.println(writer.getBuffer().toString());

		System.out.println(getMessageBrokerSettings()[0]);
		System.out.println(getMessageBrokerSettings()[1]);
		System.out.println(getMessageBrokerSettings()[2]);
		System.out.println(getMessageBrokerSettings()[3]);

	}

	public void overrideProperties(String[] args){
		for ( int i = 0; i < args.length; i++ )
		{
			String[] parts = args[i].split("=");
			getProperties().setProperty(parts[0], parts[1]);
		}
		setMessageBrokerSettings();
		printProperties();
	}	

	/**
	 * @return the properties
	 */
	public Properties getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	/**
	 * @return the messageBrokerSettings
	 */
	public String[] getMessageBrokerSettings() {
		return messageBrokerSettings;
	}

}