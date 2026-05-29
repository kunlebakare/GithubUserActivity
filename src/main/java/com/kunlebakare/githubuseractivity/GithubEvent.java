/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.kunlebakare.githubuseractivity;

/**
 *
 * @author Kunle Bakare
 */
public class GithubEvent {
    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    private boolean isPublic;
    private String created_at;
    private Org org;

    public GithubEvent(){
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GithubEvent{");
        sb.append("id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", actor=").append(actor);
        sb.append(", repo=").append(repo);
        sb.append(", payload=").append(payload);
        sb.append(", isPublic=").append(isPublic);
        sb.append(", created_at=").append(created_at);
        sb.append(", org=").append(org);
        sb.append('}');
        return sb.toString();
    }

}
