package co.id.myselfapp.models;

public class FoodModel {
    String title;
    String desc;
    String tipe;
    double rate;

    public FoodModel(String title, String desc, String tipe, double rate) {
        this.title = title;
        this.desc = desc;
        this.tipe = tipe;
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
