package com.xbirds;
import okhttp3.*;
public class GptConnector {
    public static void gtpRequest(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        String bodyString = "{" +
        "\"model\": \"gpt-3.5-turbo-0125\", " +
        "\"temperature\": 0, " +
        "\"top_p\": 1, " +
        "\"max_tokens\": 15000, " +
        "\"n\": 1, " +
        "\"messages\": [" +
        "{\"role\": \"travel-assistant\", \"content\": \"You will provide travel destinations based on the requirements and desires of the user. You will provide a list " +
        "with only the destination names. Nothing else. Approximately 10 destinations.This is the user desires: Hi i want a romantic beach destintion for a city break. I live in athens.\"}" +
        "],";
        RequestBody body = RequestBody.create(mediaType, "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"You will provide travel destinations based on the requirements and desires of the user. You will provide a list " +
        "with only the destination names. Nothing else. Approximately 10 destinations.This is the user desires: Hi i want a romantic beach destintion for a city break. I live in athens.\"}], \"temperature\": 0.7}");
        //RequestBody body = RequestBody.create(mediaType, bodyString);

        Request request = new Request.Builder()
          .url("https://api.openai.com/v1/chat/completions")
          .post(body)
          .addHeader("Content-Type", "application/json")
          .addHeader("Authorization", "Bearer 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")
          .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                System.out.println(response.body().string());
            } else {
                System.out.println("Request failed: " + response.code() + " " + response.message());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
