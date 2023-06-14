package parsers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JacksonDataBind.parseJsonFromJackson(System.getProperty("user.dir") + "\\src\\main\\resources\\user.json");
//        GsonParser.parseJsonFromGson("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5");

        JacksonDataBind.parseJackson("https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=11");
    }
}
