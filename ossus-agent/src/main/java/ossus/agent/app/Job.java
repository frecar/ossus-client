package ossus.agent.app;

import com.google.api.client.util.Key;

public class Job {

    @Key
    private long id;

    @Key("current_version_in_loop")
    private long currentVersionInLoop;

    @Key("versions_count")
    private long versionsCount;

    @Key("storage")
    private FTPStorage storage;

    @Key("name")
    private String name;

    public String getName() {
        return name;
    }

}