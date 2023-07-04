package co.id.myselfapp.models;

public class VideoModel {
    String embedUrl;

    public VideoModel(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }
}
