

package com.kunlebakare.githubuseractivity;


public class Repo {
    private int id;
    private String name;
    private String url;

    public Repo(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        sb.append("Repo{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append('}');
        return sb.toString();*/
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("/").append(url);
        return sb.toString();
    }

}
