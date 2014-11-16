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
        @Key
        public String fields;
    }

    public Server getServer(long id) {

        HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(
                new HttpRequestInitializer() {
                    @Override
                    public void initialize(HttpRequest request) {
                        request.setParser(new JsonObjectParser(JSON_FACTORY));
                    }
                });

        ServerUrl url = new ServerUrl("http://localhost:8000/api/servers/1?api_user=1&api_token=4ae0c36da907994c6458958e262c7b3f0677d035");
        HttpRequest request = null;
        try {
            request = requestFactory.buildGetRequest(url);
            return request.execute().parseAs(Server.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}