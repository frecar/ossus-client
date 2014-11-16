package ossus.agent.app;

import exceptions.InvalidSettingsException;
import junit.framework.TestCase;
import org.json.JSONObject;

import java.io.IOException;

import static org.junit.Assert.*;

public class APITest extends TestCase {

    Settings settings;

    public void setUp() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("server_ip", "127.0.0.1:8000");
        jsonObject.put("api_user", "frecar");
        jsonObject.put("api_token", "4ae0c36da907994c6458958e262c7b3f0677d035");
        jsonObject.put("agent_folder", "folder");
        jsonObject.put("local_temp_folder", "tmp_directory");
        jsonObject.put("session", "123");

        try {
            this.settings = new Settings(jsonObject);
        } catch (InvalidSettingsException e) {
            e.printStackTrace();
        }
    }

    public void testConnection() throws InvalidSettingsException, IOException {
        API api = new API(this.settings);
        Server server = api.getServer(1);
        assertEquals(1, server.getId());
    }

}