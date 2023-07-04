package co.id.myselfapp.models;

public class DailyModel {
    String image;
    String title;
    String tipe;
    int progress;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public DailyModel(String image, String title, String tipe, int progress) {
        this.image = image;
        this.title = title;
        this.tipe = tipe;
        this.progress = progress;
    }
}
