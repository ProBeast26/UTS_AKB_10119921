package co.id.myselfapp.models;

public class MusicModel {
    String nameBand;
    String titleSong;

    public MusicModel(String nameBand, String titleSong) {
        this.nameBand = nameBand;
        this.titleSong = titleSong;
    }

    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }

    public String getTitleSong() {
        return titleSong;
    }

    public void setTitleSong(String titleSong) {
        this.titleSong = titleSong;
    }
}
