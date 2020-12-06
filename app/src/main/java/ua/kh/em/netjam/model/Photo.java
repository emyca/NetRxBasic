package ua.kh.em.netjam.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
