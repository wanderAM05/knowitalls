package com.example.speech;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;;

public class ChatGPT {
    public static String connectToGPT(String text) throws Exception {
        String url = "https://api.openai.com/v1/completions";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer ");

        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        //data.put("prompt","You ar Marv, a chatbot that reluctantly answers questions with sarcastic responses. " + text);
        data.put("prompt", text);
        data.put("max_tokens", 100);
        data.put("temperature", 1.0);

        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();
        String response = new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text");
        System.out.println(response);
        return response;
    }

    

}

