package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyHelper {
    private Properties properties = new Properties();
    private InputStream inputStream;


    public PropertyHelper(String fileName) {
        try{
            inputStream = new FileInputStream("src/main/properties/"+fileName);
                } catch (FileNotFoundException e){
            e.printStackTrace();
            }
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    public String get(String key) {
        return properties.getProperty(key);
    }
}
