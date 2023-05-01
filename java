mport java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.util.Properties;
import java.net.URI;
import java.net.http.HttpClient;
import java.io.IOException;

class call {
	public static void main(String[] args) {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create((args[0]).trim()))
				.header("X-RapidAPI-Host", "jokes-by-api-ninjas.p.rapidapi.com")
				.header("X-RapidAPI-Key", "your-rapidapi-key")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
        //Properties props = System.getProperties();
//props.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.FALSE.toString());
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(response.body());
	}
}
