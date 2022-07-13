package Util;

import java.io.FileInputStream;
import java.util.Properties;

public class Config_Reader {
    public  Properties getProperties() {
       try {
           FileInputStream fis = new FileInputStream("src/main/java/Util/config.properties");
           Properties prop = new Properties();
           prop.load(fis);
           return prop;
       }
       catch (Exception e){
           e.printStackTrace();
           return null;
        }

    }

    public String getURL(){
        return getProperties().getProperty("Login_URL");
    }

    public String getUserName(){
        return getProperties().getProperty("userName");
    }

    public String getPassword(){
        return getProperties().getProperty("password");
    }


}
