package ossus.agent.app;

import com.google.api.client.util.Key;

import java.util.ArrayList;

public class Server {

    @Key
    private long id;

    @Key
    private String name;

    @Key
    private boolean active;

    @Key("auto_update")
    private boolean autoUpdate;

    @Key("external_ip")
    private String ip;

    @Key("run_install")
    private boolean runInstall;

    @Key("is_busy")
    private boolean busy;

    @Key("current_agent_version")
    private Client currentUpdater;

    @Key("current_updater_version")
    private Client currentAgent;

    @Key("selected_agent_version")
    private Client selectedAgent;

    @Key("selected_updater_version")
    private Client selectedUpdater;

    @Key("jobs")
    private ArrayList<Job> jobs;

    public String getIp() {
        return ip;
    }

    public long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isAutoUpdate() {
        return autoUpdate;
    }

    public String getName() {
        return name;
    }

    public boolean isRunInstall() {
        return runInstall;
    }

    public boolean isBusy() {
        return busy;
    }

    public Client getCurrentUpdater() {
        return currentUpdater;
    }

    public Client getCurrentAgent() {
        return currentAgent;
    }

    public ArrayList<Job> getJobs() {
        return jobs;
    }
}
