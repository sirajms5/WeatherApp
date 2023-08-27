import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

	public static void main(String[] args) {
		ApiKey apiKey = new ApiKey();		
		final String key = apiKey.getApiKey();
		Transcript transcript = new Transcript();
		transcript.setCity("Ottawa");

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

				System.out.println(response.toString());
			} else {
				System.out.println("Request failed. Response code: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
