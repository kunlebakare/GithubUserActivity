/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kunlebakare.githubuseractivity;

/**
 *
 * @author Kunle Bakare
 */
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class GithubService {

    public static String fetchUserActivity(String username) throws Exception {
        String url = "https://api.github.com/users/" + username + "/events";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/vnd.github+json")
                .header("User-Agent", "Java-GitHub-CLI-App")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Failed to fetch data. HTTP Status: " + response.statusCode());
        }
    }

    public static GithubEvent[] getEventsAsArray(String userActivity) {
        Gson gson = new Gson();
        try {
            String jsonEvents = Files.readString(Path.of("activity.json"));
            GithubEvent[] events = gson.fromJson(jsonEvents, GithubEvent[].class);
            return events;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new GithubEvent[0];

        
    }
}
