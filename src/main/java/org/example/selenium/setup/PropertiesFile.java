package org.example.selenium.setup;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile {
    static Properties properties = new Properties();
    static FileInputStream fileInputStream;

    public String fileName;

    public PropertiesFile(String fileName){
        this.fileName = fileName;
    }

    public Properties read() {
        try {
            fileInputStream = new FileInputStream(this.fileName);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Fail to read " + this.fileName);
        }
        return properties;
    }

}