package configPropertyFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class conFileReader {

    static FileInputStream file;
    static Properties properties;

    static {
        try {
            file = new FileInputStream("src/test/config.properties");
            properties = new Properties();
            properties.load(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static String getURL1()
   {
       System.out.println("URL");
        String URL=properties.getProperty("url1");
       System.out.println(URL);
        return URL;
   }
    public static String getURL2()
    {
        System.out.println("URL");
        String URL=properties.getProperty("url2");
        System.out.println(URL);
        return URL;
    }


    public static String getUserName()
    {
        String userName = properties.getProperty("username");
        return userName;
    }

    public static String getPassword()
    {
        String password = properties.getProperty("password");
        return password;
    }

    public static String getBrowser()
    {
        String browser=properties.getProperty("browser");
        return browser;
    }


    public static Long getSeconds()
    {
        Long seconds= Long.valueOf(properties.getProperty("seconds"));
        return  seconds;
    }
}