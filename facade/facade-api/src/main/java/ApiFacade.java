import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {
    String getAttributeValueFromJson(String urlString, String attributeName) throws Exception {
        String jsonResult = getJsonFromApi(urlString);
        return extractAttributeValue(jsonResult, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    public String extractAttributeValue(String json, String attributeName) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);
        // Made sure the API can parse JSON objects to string, if the response has nested objects.
        if (jsonObject.get(attributeName) instanceof String) {
            return (String) jsonObject.get(attributeName);
        }
        else if (jsonObject.get(attributeName) != null) {
            JSONObject value = (JSONObject) jsonObject.get(attributeName);
            return value.toJSONString();
        }
        else throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in response");
    }
}
