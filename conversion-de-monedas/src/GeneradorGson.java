import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorGson {
    public void guardarJson(List<Conversion> list) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escribir = new FileWriter("Historial"+".json");
        escribir.write(gson.toJson(list));
        escribir.close();
    }
}
