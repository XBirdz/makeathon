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
            return 0.0; // To handle zero vectors
        }
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
    public JSONArray jsonExtract(String json){
        
        JSONObject response = new JSONObject(json);
        JSONArray dataArray = response.getJSONArray("data");

        // Extract embeddings and save them
        JSONArray embeddings = new JSONArray();
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject item = dataArray.getJSONObject(i);
            if (item.getString("object").equals("embedding")) {
                embeddings.put(item.getJSONArray("embedding"));
            }
        }

        return embeddings;
        
    }
    public String encode(String target){
        try {
            // Set the API endpoint URL
            URL url = new URL("https://api.openai.com/v1/embeddings");

            // Create a HttpURLConnection object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method
            connection.setRequestMethod("POST");
            
            // Set request headers
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer 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");
            connection.setDoOutput(true);
            
            // Set the request body
            String requestBody = "{\"input\": \""+target+"\", \"model\": \"text-embedding-3-small\"}";
            OutputStream os = connection.getOutputStream();
            os.write(requestBody.getBytes());
            os.flush();
            
            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            // Print the response
           
            
            // Close the connection
            connection.disconnect();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}
}