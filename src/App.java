import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;


public class App {

	public static void main(String[] args) {
		ApiKey apiKey = new ApiKey();
		final String key = apiKey.getApiKey();
		Transcript transcript = new Transcript();
		transcript.setUserCity("London");

		try {
			URL url = new URL(transcript.getUrl(key));
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				BufferedReader inReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while((inputLine = inReader.readLine()) != null){
					response.append(inputLine);
				}
				inReader.close();

				Gson gson = new Gson();
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
