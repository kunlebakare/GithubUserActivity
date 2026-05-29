/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kunlebakare.githubuseractivity;

/**
 *
 * @author Kunle Bakare
 */

public class GithubUserActivity {

    public static void main(String[] args) {
        /*if (args.length == 0 || args[0].isBlank()) {
            System.out.println("A username is required");
            return;
        }
        String username = args[0];
        try {
            String activity = GithubService.fetchUserActivity(username);
            Path filePath = Path.of("activity.json");
            //Files.createFile(filePath);
            Files.writeString(filePath, activity, CREATE, TRUNCATE_EXISTING);
            System.out.println(activity);
        } catch (Exception e) {
            System.out.println(e.toString());
        }*/

        System.out.println(GithubService.getEventsAsArray("userActivity")[0]);
    }
}
