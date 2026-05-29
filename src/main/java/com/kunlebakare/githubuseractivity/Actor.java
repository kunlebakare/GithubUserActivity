/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kunlebakare.githubuseractivity;


public class Actor {
    private int id;
    private String login;
    private String display_login;
    private String gravatar_id;
    private String url;
    private String avatar_url;

    public Actor(String avatar_url, String display_login, String gravatar_id, int id, String login, String url) {
        this.avatar_url = avatar_url;
        this.display_login = display_login;
        this.gravatar_id = gravatar_id;
        this.id = id;
        this.login = login;
        this.url = url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplay_login() {
        return display_login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Actor{");
        sb.append("id=").append(id);
        sb.append(", login=").append(login);
        sb.append(", display_login=").append(display_login);
        sb.append(", gravatar_id=").append(gravatar_id);
        sb.append(", url=").append(url);
        sb.append(", avatar_url=").append(avatar_url);
        sb.append('}');
        return sb.toString();
    }

}
