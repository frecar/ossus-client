package ossus.agent.app;

import junit.framework.TestCase;
import org.json.JSONObject;

public class SettingsTest extends TestCase {

    public void testBuildInvalidSettings() {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("ip", "127.0.0.1");

        try {
            new Settings(jsonObject);
            assert false;
        } catch (InvalidSettingsException e) {
            assert true;
        }

    }

    public void testBuildSettingsFromJsonObject() throws InvalidSettingsException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("ip", "127.0.0.1");
        jsonObject.put("api_user", "test_user");
        jsonObject.put("api_token", "test_token");
        jsonObject.put("working_directory", "folder");
        jsonObject.put("tmp_directory", "tmp_directory");
        jsonObject.put("session", "123");

        Settings settings = new Settings(jsonObject);

        assertEquals("127.0.0.1", settings.getIp());
        assertEquals("test_user", settings.getApiUser());

    }

}