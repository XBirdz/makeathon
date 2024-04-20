package com.xbirds;
import okhttp3.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
public class GptConnector {
    public static List<String> handleUserInp(String userPrompt){
        return jsonExtract(gtpRequest(userPrompt));
    }
    public static String gtpRequest(String userPrompt){
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
                return response.body().string();
            } else {
                return "Request failed: " + response.code() + " " + response.message();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    

    public static List<String> jsonExtract(String jsonString){
        List<String> destinations = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);

            JsonNode choicesNode = jsonNode.get("choices");
            if (choicesNode != null && choicesNode.isArray() && choicesNode.size() > 0) {
                JsonNode messageNode = choicesNode.get(0).get("message");
                if (messageNode != null) {
                    String destinationsString = messageNode.get("content").asText();
                    // Split the destinations string by newline character
                    String[] destinationArray = destinationsString.split("\\n");
                    for (String destination : destinationArray) {
                        // Remove the leading number and space from each destination
                        destination = destination.replaceFirst("^\\d+\\.\\s*", "");
                        destinations.add(destination);
                    }
                }
            }
            return destinations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
