package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    public final static String TEST_DATA_PATH = "src/test/resources/";

    //TODO: Read data from json file
    public static String getJsonData(String jsonFilename, String field) {
        try {
            //Define object of file Reader
            FileReader reader = new FileReader("src/test/resources/TestData/validLogin.json");
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(field).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    //TODO: Get Properties from any .Properties file

    public static String getPropertyByValue(String filename, String key) throws IOException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/TestData/environments.properties"));
        return properties.getProperty(key);
    }


}
