package ossus.agent.app;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Key;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class API {

    private Settings settings;

    public API(Settings settings) {
        this.settings = settings;
    }

    static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    static final JsonFactory JSON_FACTORY = new JacksonFactory();

    public static class ServerUrl extends GenericUrl {
        public ServerUrl(String encodedUrl) {
            super(encodedUrl);
        }
    }

    private ServerUrl buildServerUrl(String str) {
        String host = settings.getServer_ip();
        String auth = "?api_user=" + settings.getApiUser() + "&&api_token=" + settings.getApiToken();

        if(!host.endsWith("/")) {
            host+="/";
        }

        return new ServerUrl(host + "api/" + str + auth);
    }

    public Server getServer() throws IOException {

        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) {
                        request.setParser(new JsonObjectParser(JSON_FACTORY));
                    }
                });

        ServerUrl url = buildServerUrl("servers/"+settings.getId());

        HttpRequest request = null;

        request = requestFactory.buildGetRequest(url);
        return request.execute().parseAs(Server.class);
    }

}