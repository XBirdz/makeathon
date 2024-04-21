package com.xbirds;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
public class Embeddings {
    public List<JSONArray> embeddings = new ArrayList<>();
    public JSONArray targetemb = new JSONArray();

    private double cosineSimilarity(JSONArray emb1, JSONArray emb2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (int i = 0; i < emb1.length(); i++) {
            dotProduct += emb1.getDouble(i) * emb2.getDouble(i);
            norm1 += Math.pow(emb1.getDouble(i), 2);
            norm2 += Math.pow(emb2.getDouble(i), 2);
        }
        if (norm1 == 0 || norm2 == 0) {
            return 0.0;
        }
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
    public List<JSONArray> extractEmbeddings(String json) {
        JSONObject response = new JSONObject(json);
        JSONArray dataArray = response.getJSONArray("data");

        List<JSONArray> embeddingsList = new ArrayList<>();
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);
            if (item.getString("object").equals("embedding")) {
                embeddingsList.add(item.getJSONArray("embedding"));
            }
        }

        return embeddingsList;
    }
    public String encode(String target){
        try {
           
            URL url = new URL("https://api.openai.com/v1/embeddings");

          
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
        
            connection.setRequestMethod("POST");
            
      
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer sk-proj-kiZn5aYO0WdLoCmQSjB1T3BlbkFJKPrq5FxsWdBzgJ39XoUE");
            connection.setDoOutput(true);
            
            
            String requestBody = "{\"input\": \""+target+"\", \"model\": \"text-embedding-3-small\"}";
            OutputStream os = connection.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
           
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
           
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}
public List<Integer> findClosestPhraseIndices(String target, List<String> phrases) {
    List<Integer> closestIndices = new ArrayList<>();
    String targetEncoding = encode(target);
    List<JSONArray> phraseEmbeddings = new ArrayList<>();

   
    for (String phrase : phrases) {
        String encoding = encode(phrase);
        JSONArray embedding = extractEmbeddings(encoding).get(0);
        phraseEmbeddings.add(embedding);
    }

  
    Map<Integer, Double> similarityMap = new HashMap<>();
    for (int i = 0; i < phrases.size(); i++) {
        double similarity = cosineSimilarity(extractEmbeddings(targetEncoding).get(0), phraseEmbeddings.get(i));
        similarityMap.put(i, similarity);
    }

   
    similarityMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(3)
            .forEach(entry -> closestIndices.add(entry.getKey()));

    return closestIndices;
}
}