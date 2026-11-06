package com.kunlebakare.githubuseractivity;

import com.google.gson.JsonElement;
import com.kunlebakare.githubuseractivity.payloads.Payload;

/**
 *
 * @author Kunle Bakare
 */
public class GithubEvent {

    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private JsonElement payload;
    private Payload eventPayload;
    private boolean isPublic;
    private String created_at;
    private Org org;

    public GithubEvent() {
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

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Actor getActor() {
        return actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public JsonElement getPayload() {
        return payload;
    }

    public Payload getEventPayload() {
        return this.eventPayload;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public String getCreated_at() {
        return created_at;
    }

    public Org getOrg() {
        return org;
    }

    public void setEventPayload(Payload payload) {
        this.eventPayload = payload;
    }

}
