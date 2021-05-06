package util;

// Import Statements
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UtilProp {
	// Global Variables
	static final boolean _W = System.getProperty("os.name").toLowerCase().contains("windows");
	static String _PROP_FILENAME_WIN_LOCAL = "D:\\Git Repositories\\CSCI4830-Group-Project\\FinalProject\\WebContent\\config.properties";
	static String _PROP_FILENAME_OSX_LOCAL = "/YOUR_PATH/webproject/WebContent/config.properties";
	// * Remote server path
	static String _PROP_FILENAME_REMOTE = "/var/lib/tomcat7/webapps/FinalProject/config.properties";
	static Properties prop = new Properties();

	// Class to load config.properties file depending on system
	public static void loadProperty() throws Exception {
		// Instance Variables
		FileInputStream inputStream = null;
		
		// Windows Machine
		if (_W) {
			if (new File(_PROP_FILENAME_WIN_LOCAL).exists()) {
				inputStream = new FileInputStream(_PROP_FILENAME_WIN_LOCAL);
			}
			
		// MacOS Machine
		} else {
			if (new File(_PROP_FILENAME_OSX_LOCAL).exists()) {
				inputStream = new FileInputStream(_PROP_FILENAME_OSX_LOCAL);
			}
		}
		
		// Linux Machine
		if (new File(_PROP_FILENAME_REMOTE).exists()) {
			inputStream = new FileInputStream(_PROP_FILENAME_REMOTE);
		}
		
		// If config.properties file was not able to be found, throw error
		if (inputStream == null) {
			throw new FileNotFoundException();
		}
		
		// Load properties file
		prop.load(inputStream);
	}

	// Return key retrieved from config file
	public static String getProp(String key) {
		return prop.getProperty(key).trim();
	}
}
