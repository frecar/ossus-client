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
        jsonObject.put("ip", "127.0.0.1:8000");
        jsonObject.put("api_user", "frecar");
        jsonObject.put("api_token", "4ae0c36da907994c6458958e262c7b3f0677d035");
        jsonObject.put("working_directory", "folder");
        jsonObject.put("tmp_directory", "tmp_directory");
        jsonObject.put("session", "123");

        //settings = new Settings(jsonObject);

    }

    public void testConnection() throws InvalidSettingsException, IOException {

        API api = new API();
        Server server = api.get("1");

        System.out.println(server.getId());
        System.out.println(server.getIp());
        System.out.println(server.isActive());
        System.out.println(server.isAutoUpdate());
        System.out.println(server.getName());
        System.out.println(server.isRunInstall());
        System.out.println(server.isBusy());

        System.out.println(server.getCurrentAgent().getDownloadURL());
        System.out.println(server.getCurrentUpdater().getDownloadURL());

        System.out.println(server.getJobs().get(0).getName());

    }

}