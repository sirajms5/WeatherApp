import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

/**
 * The WeatherApiConnector class provides functionality to send HTTP requests to a weather API
 * and retrieve weather data for a specified city using the API key. It sends a GET request to
 * the API, processes the response, and maps the data to a Transcript object for further use.
 * This class utilizes the Gson library for JSON parsing.
 * 
 * @author Siraj Mohammed Saleem
 * @version 1.0
 * @see Transcript
 * @see com.google.gson.Gson
 * @since 1.0
 */
public class WeatherApiConnector {
    private final String BASEURL = "http://api.weatherapi.com/v1"; // Base URL of the weather API

    /**
     * Constructs the full URL for the weather API request.
     *
     * @param key  The API key for authentication.
     * @param city The name of the city for which weather data is requested.
     * @return The full URL for the API request.
     */
    private String getUrl(String key, String city) {
        return BASEURL + "/current.json?key=" + key + "&q=" + city;
    }

    /**
     * Sends an HTTP GET request to the weather API, retrieves weather data for the specified city,
     * and maps it to a Transcript object.
     *
     * @param key  The API key for authentication.
     * @param city The name of the city for which weather data is requested.
     * @return A Transcript object containing the weather data.
     */
    public Transcript sendRequest(String key, String city) {
        Transcript transcript = new Transcript(); // Initialize an empty transcript

        try {
            URL url = new URL(getUrl(key, city)); // Create the URL for the API request
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // create HttpURLConnection
            connection.setRequestMethod("GET"); // Set the request method to GET

            int responseCode = connection.getResponseCode(); // Get the HTTP response code

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader inReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = inReader.readLine()) != null) {
                    response.append(inputLine);
                }
                inReader.close();

                Gson gson = new Gson();
                // Map the JSON response to the transcript object
                transcript = gson.fromJson(response.toString(), Transcript.class);

                transcript.setCreated(true);
            } else {
                System.out.println("Request failed. Response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return transcript;
    }
}
