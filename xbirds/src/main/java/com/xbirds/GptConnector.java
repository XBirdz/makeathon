package com.xbirds;
import okhttp3.*;
public class GptConnector {
    public static void gtpRequest(){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"model\": \"gpt-3.5-turbo-0125\", \"temperature\": 0, \"top_p\": 1, \"max_tokens\": 1200, \"n\": 1, \"messages\": [{\"role\": \"user\", \"content\": \"Hello, how are you?\"}]}");

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
