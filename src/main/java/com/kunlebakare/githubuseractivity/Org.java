/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kunlebakare.githubuseractivity;


public class Org {
    public int id;
    public String login;
    public String gravatar_id;
    public String url;
    public String avatar_url;

    public Org(String avatar_url, String gravatar_id, int id, String login, String url) {
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.id = id;
        this.login = login;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Org{");
        sb.append("id=").append(id);
        sb.append(", login=").append(login);
        sb.append(", gravatar_id=").append(gravatar_id);
        sb.append(", url=").append(url);
        sb.append(", avatar_url=").append(avatar_url);
        sb.append('}');
        return sb.toString();
    }
}
