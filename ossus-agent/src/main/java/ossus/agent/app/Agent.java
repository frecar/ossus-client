package ossus.agent.app;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ConnectException;

import exceptions.InvalidSettingsException;

public class Agent {

    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("You need to specify a settings file, for example: java -jar agent.jar /path/to/settings.json");
            return;
        }

        String settingsPath = args[0];

        FileReader fileReader = null;
        Settings settings = null;

        try {
            JsonObjectParser parser = new JsonObjectParser(JSON_FACTORY);

            fileReader = new FileReader(settingsPath);
            settings = parser.parseAndClose(fileReader, Settings.class);

            if (!settings.verify()) {
                throw new InvalidSettingsException("Invalid settings..");
            }

            Server server = new API(settings).getServer();

        } catch (FileNotFoundException e) {
            System.err.println("Settings file '" + settingsPath + "' not found, are sure this is the correct path?");
        } catch (ConnectException e) {
            assert settings != null;
            System.err.println("Can't connect to host: " + settings.getServer_ip() +
                    "\nPlease verify hostname, api_user and api_token");
        } catch (InvalidSettingsException e) {
            System.err.println("Settings are invalid, is it json? " +
                    "Have you remembered to fill in all required fields?");
        } catch (IOException e) {
            System.err.println("Can't parse the settings file. The settings field contains invalid json");
        }

        //Server server = new API(settings).getServer();
        //System.out.println(server.getIp());
    }
}
