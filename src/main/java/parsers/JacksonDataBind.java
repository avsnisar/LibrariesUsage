package parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rest.api.CurrencyRate;
import rest.api.ForGsonUse;
import serialization.basic.JacksonUser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JacksonDataBind {

    public static void parseJsonFromJackson(String path){
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonUser jacksonUser = null;
        try {
            jacksonUser = objectMapper.readValue(new File(path), JacksonUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(jacksonUser);
    }

    public static void parseJackson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CurrencyRate[] currecyRates = objectMapper.readValue(new URL(path), CurrencyRate[].class);

        for (CurrencyRate currecyRate : currecyRates) {
            System.out.println(currecyRate);
        }

        String jacksonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currecyRates);
        Files.write(Paths.get("E:\\Study\\!Java\\+Lynda.com - Java Essential Training (2015) IntelliJ IDEA\\Exercise Files\\12_Deployment\\LibrariesUsage\\src\\main\\resources\\PBcurrenciesOnline.json")
                ,jacksonString.getBytes(), StandardOpenOption.CREATE);
    }
}