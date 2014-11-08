package ossus.agent.app;

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

    private String id;
    private String ip;
    private String apiUser;
    private String apiToken;
    private String workingDirectory;
    private String tmpDirectory;
    private String session;

    public Settings(JSONObject data) throws InvalidSettingsException {
        try {
            this.ip = (String) data.get("ip");
            this.id = (String) data.get("id");
            this.apiUser = (String) data.get("api_user");
            this.apiToken = (String) data.get("api_token");
            this.workingDirectory = (String) data.get("working_directory");
            this.tmpDirectory = (String) data.get("tmp_directory");
            this.session = (String) data.get("session");

        } catch (JSONException e) {
            throw new InvalidSettingsException("You need to specify all required fields in settings file: " + e);
        }
    }

    public String getIp() {
        return ip;
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

    public String getSession() {
        return session;
    }

    public String getId() {
        return id;
    }
}
