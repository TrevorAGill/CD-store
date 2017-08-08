package models;


import java.util.ArrayList;

public class CD {
    private String artistName;
    private String albumName;
    private int releaseYear;
    private int price;

    public static ArrayList<CD> allCDs = new ArrayList<CD>();

    public CD (String artistName, String albumName, int releaseYear, int price) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.price = price;
        allCDs.add(this);
    }

    public static ArrayList<CD> getAll(){
        return allCDs;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getPrice() {
        return price;
    }
}
