package ossus.agent.app;

import com.google.api.client.util.Key;

public class FTPStorage
{

    @Key
    private String username;

    @Key
    private String password;

    @Key
    private String currentDayFolder;

    @Key
    private String host;

    @Key
    private String folder;

}
