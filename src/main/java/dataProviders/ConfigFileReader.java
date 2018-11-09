package dataProviders;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    public String getProp(String key) throws IOException {
        Properties prop = new Properties();
        InputStream in = ClassLoader.getSystemResourceAsStream("configuration.properties");
        prop.load(in);
        return prop.getProperty(key);
    }
}
