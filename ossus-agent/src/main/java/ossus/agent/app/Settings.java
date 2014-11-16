package ossus.agent.app;

import com.google.api.client.util.Key;
import exceptions.InvalidSettingsException;
import org.json.JSONException;
import org.json.JSONObject;

public class Settings {

    /*
    this.server_ip = settings.get("server_ip");
		this.id = settings.get("id");
        this.api_user = settings.get("api_user");
        this.api_token = settings.get("api_token");
		this.os_system = settings.get("os_system");
		this.downloads_client = settings.get("downloads_client");
		this.mysql_dump = settings.get("mysql_dump");
		this.agent_folder = settings.get("agent_folder");
		this.local_temp_folder = settings.get("local_temp_folder");
        this.session = (System.currentTimeMillis() / 1000) + new Random().nextInt(150);
     */

    @Key("id")
    private String id;

    @Key("server_ip")
    private String server_ip;

    @Key("api_user")
    private String apiUser;

    @Key("mysql_dump")
    private String mysqlDump;

    @Key("api_token")
    private String apiToken;

    @Key("agent_folder")
    private String workingDirectory;

    @Key("local_temp_folder")
    private String tmpDirectory;

    public Settings() {}

    public Settings(JSONObject data) throws InvalidSettingsException {
        try {
            this.server_ip = (String) data.get("server_ip");
            this.id = (String) data.get("id");
            this.apiUser = (String) data.get("api_user");
            this.apiToken = (String) data.get("api_token");
            this.workingDirectory = (String) data.get("agent_folder");
            this.tmpDirectory = (String) data.get("local_temp_folder");

        } catch (JSONException e) {
            throw new InvalidSettingsException("You need to specify all required fields in settings file: " + e);
        }
    }

    public String getServer_ip() {
        return server_ip;
    }

    public String getApiUser() {
        return apiUser;
    }

    public String getApiToken() {
        return apiToken;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public String getTmpDirectory() {
        return tmpDirectory;
    }

    public String getId() {
        return id;
    }

    public String getMysqlDump() {
        return mysqlDump;
    }
}
