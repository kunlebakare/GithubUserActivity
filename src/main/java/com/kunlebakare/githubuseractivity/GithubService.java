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
import java.util.ArrayList;

import com.google.gson.Gson;
import com.kunlebakare.githubuseractivity.payloads.CommitCommentPayload;
import com.kunlebakare.githubuseractivity.payloads.CreatePayload;
import com.kunlebakare.githubuseractivity.payloads.DeletePayload;
import com.kunlebakare.githubuseractivity.payloads.DiscussionPayload;
import com.kunlebakare.githubuseractivity.payloads.ForkPayload;
import com.kunlebakare.githubuseractivity.payloads.GollumPayload;
import com.kunlebakare.githubuseractivity.payloads.IssueCommentPayload;
import com.kunlebakare.githubuseractivity.payloads.IssuesPayload;
import com.kunlebakare.githubuseractivity.payloads.MemberPayload;
import com.kunlebakare.githubuseractivity.payloads.PublicPayload;
import com.kunlebakare.githubuseractivity.payloads.PullRequestPayload;
import com.kunlebakare.githubuseractivity.payloads.PullRequestReviewCommentPayload;
import com.kunlebakare.githubuseractivity.payloads.PullRequestReviewPayload;
import com.kunlebakare.githubuseractivity.payloads.PushPayload;
import com.kunlebakare.githubuseractivity.payloads.ReleasePayload;
import com.kunlebakare.githubuseractivity.payloads.WatchPayload;

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

    public static ArrayList<GithubEvent> getEvents() {
        ArrayList<GithubEvent> eventsWithPayloads = new ArrayList<>();
        Gson gson = new Gson();

        try {
            String jsonEvents = Files.readString(Path.of("activity.json"));
            GithubEvent[] events = gson.fromJson(jsonEvents, GithubEvent[].class);

            for (GithubEvent event : events) {
                switch (event.getType()) {
                    case "CommitCommentEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), CommitCommentPayload.class));
                    case "CreateEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), CreatePayload.class));
                    case "DeleteEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), DeletePayload.class));
                    case "DiscussionEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), DiscussionPayload.class));
                    case "ForkEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), ForkPayload.class));
                    case "GollumEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), GollumPayload.class));
                    case "IssueCommentEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), IssueCommentPayload.class));
                    case "IssuesEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), IssuesPayload.class));
                    case "MemberEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), MemberPayload.class));
                    case "PublicEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), PublicPayload.class));
                    case "PullRequestEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), PullRequestPayload.class));
                    case "PullRequestReviewEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), PullRequestReviewPayload.class));
                    case "PullRequestReviewCommentEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), PullRequestReviewCommentPayload.class));
                    case "PushEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), PushPayload.class));
                    case "ReleaseEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), ReleasePayload.class));
                    case "WatchEvent" ->
                        event.setEventPayload(gson.fromJson(event.getPayload(), WatchPayload.class));
                }
                eventsWithPayloads.add(event);
            }
            return eventsWithPayloads;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ArrayList<>();
    }

    public static void reportEvents(ArrayList<GithubEvent> events) {
        /*HashMap<String, Integer> eventCounter = new HashMap<>();
        eventCounter.put("CommitCommentEvent", 0);
        eventCounter.put("CreateEvent", 0);
        eventCounter.put("DeleteEvent", 0);
        eventCounter.put("DiscussionEvent", 0);
        eventCounter.put("ForkEvent", 0);
        eventCounter.put("GollumEvent", 0);
        eventCounter.put("IssueCommentEvent", 0);
        eventCounter.put("IssuesEvent", 0);
        eventCounter.put("MemberEvent", 0);
        eventCounter.put("PublicEvent", 0);
        eventCounter.put("PullRequestEvent", 0);
        eventCounter.put("PullRequestReviewEvent", 0);
        eventCounter.put("PullRequestReviewCommentEvent", 0);
        eventCounter.put("PushEvent", 0);
        eventCounter.put("ReleaseEvent", 0);
        eventCounter.put("WatchEvent", 0);
        eventCounter.put("CommitCommentEvent", 0);

        

        for (GithubEvent event : events) {
            int value = eventCounter.get(event.getType());
            eventCounter.put(event.getType(), value + 1);
        }

        for (String event : eventCounter.keySet()) {
            int count = eventCounter.get(event);
            if (count > 0) {
                switch (event) {
                    case "CommitCommentEvent" -> {
                        System.out.println("Created " + count + " Commit Comment" + (count > 1 ? "s" : ""));
                    }
                    case "CreateEvent" ->
                        System.out.println("Created " + count + " Git branch" + (count > 1 ? "es" : "")+ "or tag" + (count > 1 ? "s" : ""));
                    case "DeleteEvent" ->
                        System.out.println("Deleted " + count + " Git branch" + (count > 1 ? "es" : "")+ "or tag" + (count > 1 ? "s" : ""));
                    case "DiscussionEvent" ->
                        System.out.println("Created " + count + " discussion"  + (count > 1 ? "s" : "")+ " in --- repository");
                    case "ForkEvent" ->
                        System.out.println("Forked --- repo");
                    case "GollumEvent" ->
                        System.out.println("--- wiki page was created or updated");
                    case "IssueCommentEvent" ->
                        System.out.println("ACTION ");
                    case "IssuesEvent" ->
                        System.out.println("ACTION");
                    case "MemberEvent" ->
                        System.out.println("ACTION");
                    case "PublicEvent" ->
                        System.out.println("Made a private repo public");
                    case "PullRequestEvent" ->
                        System.out.println("ACTION");
                    case "PullRequestReviewEvent" ->
                        System.out.println("ACTION");
                    case "PullRequestReviewCommentEvent" ->
                        System.out.println("ACTION");
                    case "PushEvent" ->
                        System.out.println("Pushed " + count + " commit" + (count > 1 ? "s" : "")+ " REPo");
                    case "ReleaseEvent" ->
                        System.out.println("ACTION");
                    case "WatchEvent" ->
                        System.out.println("Starred a repo--");
                }
            }
        }*/

        for (GithubEvent event : events) {
            switch (event.getType()) {
                case "CommitCommentEvent" -> {
                    System.out.println("Created a Commit Comment in " + event.getRepo());
                }
                case "CreateEvent" ->
                    System.out.println("Created a " + event.getPayload().getAsJsonObject().get("ref_type") + "in "+ event.getRepo());
                case "DeleteEvent" ->
                    System.out.println("Deleted " + " Git branch" + "or tag");
                case "DiscussionEvent" ->
                    System.out.println("Created " + " discussion" + " in --- repository");
                case "ForkEvent" ->
                    System.out.println("Forked --- repo");
                case "GollumEvent" ->
                    System.out.println("--- wiki page was created or updated");
                case "IssueCommentEvent" ->
                    System.out.println("ACTION ");
                case "IssuesEvent" ->
                    System.out.println("ACTION");
                case "MemberEvent" ->
                    System.out.println("ACTION");
                case "PublicEvent" ->
                    System.out.println("Made a private repo public");
                case "PullRequestEvent" ->
                    System.out.println("ACTION");
                case "PullRequestReviewEvent" ->
                    System.out.println("ACTION");
                case "PullRequestReviewCommentEvent" ->
                    System.out.println("ACTION");
                case "PushEvent" ->
                    System.out.println("Pushed " + " commit"+ " REPo");
                case "ReleaseEvent" ->
                    System.out.println("ACTION");
                case "WatchEvent" ->
                    System.out.println("Starred a repo--");
                default ->
                    throw new IllegalStateException("Unexpected value: " + event);
            }
        }
    }
}
