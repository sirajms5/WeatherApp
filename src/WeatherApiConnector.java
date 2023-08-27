import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class WeatherApiConnector {
    private final String BASEURL = "http://api.weatherapi.com/v1";

    private String getUrl(String key, String city) {
        return BASEURL + "/current.json?key=" + key + "&q=" + city;
    }

    public void sendRequest(String key, String city) {
        try {
            URL url = new URL(getUrl(key, city));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = inReader.readLine()) != null) {
                    response.append(inputLine);
                }
                inReader.close();

                Gson gson = new Gson();
                Transcript transcript = new Transcript();
                transcript = gson.fromJson(response.toString(), Transcript.class); // mapping response to instance variable

                System.out.println(transcript.getLocation().getCountry());
            } else {
                System.out.println("Request failed. Response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
