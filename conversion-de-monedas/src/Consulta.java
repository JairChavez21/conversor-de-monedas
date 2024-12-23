import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public Conversion convierte(String base, String target, int amount) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e77f64d9a01f60ab8c2ac312/pair/"+base+"/"+target+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}