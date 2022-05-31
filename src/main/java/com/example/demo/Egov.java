package com.example.demo;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class Egov {
    private final String url = "https://data.egov.kz/api/v4/zhogary_oku_oryndarynyn_tizbes/v5?apiKey=4fd3c4fa864e43bd94448a7914833386";

    public String getJson(){
        try {
            return getResponseByURL(new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return "nothing";
    }

    private String getResponseByURL(URL url){
        String result = "";
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            result = response.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(result);
        return result;
    }
}
