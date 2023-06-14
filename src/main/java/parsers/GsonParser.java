package parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import rest.api.CurrencyRate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class GsonParser {
    public static void parseJsonFromGson(String url) throws IOException {
        GsonBuilder gsonbuilder = new GsonBuilder();
        gsonbuilder.setPrettyPrinting();

        Gson gson = gsonbuilder.create();

        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));

        CurrencyRate[] currencyRates = gson.fromJson(jsonReader, CurrencyRate[].class);
        for (CurrencyRate currencyRate : currencyRates) {
            System.out.println(currencyRate);
        }

        String gsonString = gson.toJson(currencyRates);

        Files.write(Paths.get("E:\\Study\\!Java\\+Lynda.com - Java Essential Training (2015) IntelliJ IDEA\\Exercise Files\\12_Deployment\\LibrariesUsage\\src\\main\\resources\\PBcurrenciesCash.json"),
                gsonString.getBytes(), StandardOpenOption.CREATE);
    }
}
