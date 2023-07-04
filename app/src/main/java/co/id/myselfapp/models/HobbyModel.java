package co.id.myselfapp.models;

public class HobbyModel {
    String name;

    public HobbyModel(String name, int image, String myOpinion, int myInterest) {
        this.name = name;
        this.image = image;
        this.myOpinion = myOpinion;
        this.myInterest = myInterest;
    }

    int image;
    String myOpinion;
    int myInterest;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMyOpinion() {
        return myOpinion;
    }

    public void setMyOpinion(String myOpinion) {
        this.myOpinion = myOpinion;
    }

    public int getMyInterest() {
        return myInterest;
    }

    public void setMyInterest(int myInterest) {
        this.myInterest = myInterest;
    }


}
