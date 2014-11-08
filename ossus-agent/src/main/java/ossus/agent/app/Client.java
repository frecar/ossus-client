package ossus.agent.app;

import com.google.api.client.util.Key;

public class Client {

    @Key
    private long id;

    @Key("updater_link")
    private String updaterLink;

    @Key("agent_link")
    private String agentLink;

    @Key("name")
    private String name;

    @Key("current_agent")
    private boolean currentAgent;

    @Key("current_updater")
    private boolean currentUpdater;

    public String getDownloadURL() {
        if(this.currentAgent) {
            return this.agentLink;
        }
        else {
            return this.updaterLink;
        }
    }
}
