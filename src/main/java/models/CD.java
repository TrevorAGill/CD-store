package models;

/**
 * Created by Guest on 7/31/17.
 */
public class CD {
    public String artistName;
    public String albumName;
    public int releaseYear;
    public int price;


    public CD (String artistName, String albumName, int releaseYear, int price) {
        this.artistName = artistName ;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.price = price;
    }
}
