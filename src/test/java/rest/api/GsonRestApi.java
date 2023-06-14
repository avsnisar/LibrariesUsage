package rest.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GsonRestApi {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        ForGsonUse source = new ForGsonUse();
        source.setAudio_url("https://github.com/johnmarty3/JavaAPITutorial/blob/main/Thirsty.mp3?row=true");

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(source);

        System.out.println(jsonRequest);
        System.out.println("JSON sting отримано");
//      або так
//      System.out.println(new Gson().toJson(source));

        HttpRequest postRequest = HttpRequest
                .newBuilder().uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", "868c02208c1246249d4ed7b18abd93d9")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
//                .POST(HttpRequest.BodyPublishers.ofString("\"audio_url\": \"https://github.com/johnmarty3/JavaAPITutorial/blob/main/Thirsty.mp3?row=true\""))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> httpPostResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        source = gson.fromJson(httpPostResponse.body(), ForGsonUse.class);
        System.out.println(httpPostResponse.body());
        System.out.println("Відповідь на ПОСТ запит отримано");

        HttpRequest getRequest = HttpRequest
                .newBuilder().uri(new URI("https://api.assemblyai.com/v2/transcript/" + source.getId()))
                .header("Authorization", "868c02208c1246249d4ed7b18abd93d9")
                .GET()
                .build();

        while (true) {
            HttpResponse<String> httpGetResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
            source = gson.fromJson(httpGetResponse.body(), ForGsonUse.class);
            System.out.println(source.getStatus());
            System.out.println("Відповідь на ГЕТ запит зі статусом отримано");

            if("completed".equals(source.getStatus()) || "error".equals(source.getStatus())){
                break;
            }
            Thread.sleep(3000);
        }
        System.out.println("Завершення декодування тексу з відеофайлу");
        System.out.println(source.getText());
    }
}
