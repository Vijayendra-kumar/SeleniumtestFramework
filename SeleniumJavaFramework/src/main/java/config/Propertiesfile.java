package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Propertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getProperties();
	}

	public static void getProperties() throws IOException {

		try {
			Properties prop = new Properties();

		String project_path = System.getProperty("user.dir");

			InputStream input = new FileInputStream(project_path+"/src/main/java/config/configfile.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println("brower = "+browser);
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.getCause();
			// TODO Auto-generated catch block
			e.printStackTrace();


		}
	}


}
