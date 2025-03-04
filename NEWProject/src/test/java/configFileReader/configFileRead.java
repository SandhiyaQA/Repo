package configFileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configFileReader {

   static FileInputStream fileInputStream;
    static Properties properties;

    {
        try {
            fileInputStream = new FileInputStream("configfile.properties");
             properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static String getURL()
    {
         String getUrl = properties.getProperty("url");

        return getUrl;
    }
}
