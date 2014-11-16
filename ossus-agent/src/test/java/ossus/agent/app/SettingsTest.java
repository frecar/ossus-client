package ossus.agent.app;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import exceptions.InvalidSettingsException;
import junit.framework.TestCase;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SettingsTest extends TestCase {

    public void testBuildInvalidSettings() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("server_ip", "127.0.0.1");

        try {
            new Settings(jsonObject);
            assert false;
        } catch (InvalidSettingsException e) {
            assert true;
        }

    }

    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public void testBuildSettingsFromFile() throws IOException {

        try {
            FileReader fileReader = new FileReader("src/main/resources/example_settings_1.json");
            JsonObjectParser parser = new JsonObjectParser(JSON_FACTORY);

            Settings settings = parser.parseAndClose(fileReader, Settings.class);

            assertEquals("1", settings.getId());
            assertEquals("1", settings.getApiUser());
            assertEquals("4ae0c36da907994c6458958e262c7b3f0677d035", settings.getApiToken());
            assertEquals("C:\\focus24\\temp\\", settings.getTmpDirectory());
            assertEquals("C:\\focus24\\", settings.getWorkingDirectory());
            assertEquals("http://localhost:8000/", settings.getServer_ip());
            assertEquals("mysqldump", settings.getMysqlDump());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void testBuildSettingsFromJsonObject() throws InvalidSettingsException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("server_ip", "127.0.0.1");
        jsonObject.put("api_user", "test_user");
        jsonObject.put("api_token", "test_token");
        jsonObject.put("agent_folder", "folder");
        jsonObject.put("local_temp_folder", "tmp_directory");

        Settings settings = new Settings(jsonObject);

        assertEquals("127.0.0.1", settings.getServer_ip());
        assertEquals("test_user", settings.getApiUser());
        assertEquals("folder", settings.getWorkingDirectory());

    }
}