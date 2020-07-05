package ua.kh.em.netrxbasic.model;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
