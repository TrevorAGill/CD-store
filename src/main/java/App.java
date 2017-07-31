import models.CD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Guest on 7/31/17.
 */

public class App {
    public static void main(String[] args) {


        CD Rock = new CD ("Ted Nuget", "Just The Best",2005,5);
        CD Rap = new CD ("Tupac", "Im super dead",2015,9);
        CD Country = new CD ("Johhny Cash", "Fire",1989,12);
        CD Jazz = new CD ("Miles Davis", "Miles Ahead",1976,10);
        ArrayList<CD> allCDs = new ArrayList<CD>();
        allCDs.add(Rock);
        allCDs.add(Rap);
        allCDs.add(Country);
        allCDs.add(Jazz);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to our CD store. What would you like to do? Enter one of the following options: Browse selection, Add CD, or Exit");
        boolean programRunning = true;

        while (programRunning) {

            try {
                String navigationChoice = bufferedReader.readLine();
                if (navigationChoice.equals("Browse selection")) {
                    System.out.println("Do you want to see 'all CDs', filter by 'release year', or filter by 'price'");
                    String browseChoice = bufferedReader.readLine();
                    if (browseChoice.equals("all CDs")) {
                        for (CD individualCD : allCDs) {
                            System.out.println("----------------------");
                            System.out.println(individualCD.artistName);
                            System.out.println(individualCD.albumName);
                            System.out.println(individualCD.releaseYear);
                            System.out.println(individualCD.price);
                        }
                    } else if (browseChoice.equals("release year")) {
                        System.out.println("See all albums after this year. Enter year");
                        int userYearBrowse = Integer.parseInt(bufferedReader.readLine());
                        for (CD individualCD : allCDs) {
                            if (individualCD.releaseYear >= userYearBrowse) {
                                System.out.println("----------------------");
                                System.out.println(individualCD.artistName);
                                System.out.println(individualCD.albumName);
                                System.out.println(individualCD.releaseYear);
                                System.out.println(individualCD.price);
                            }
                        }
                    } else if (browseChoice.equals("price")) {
                        System.out.println("Enter your maximum price");
                        int userMaxPrice = Integer.parseInt(bufferedReader.readLine());
                        for (CD individualCD : allCDs) {
                            if (individualCD.price <= userMaxPrice) {
                                System.out.println("----------------------");
                                System.out.println(individualCD.artistName);
                                System.out.println(individualCD.albumName);
                                System.out.println(individualCD.releaseYear);
                                System.out.println(individualCD.price);
                            }
                        }
                    }
                } else if (navigationChoice.equals("Add CD")) {
                    System.out.println("Alright, let's add a CD! What is the artist's name?");
                    String userAristName = bufferedReader.readLine();
                    System.out.println("What is the albumn name?");
                    String userAlbumnName = bufferedReader.readLine();
                    System.out.println("What is the release year?");
                    int userReleaseYear = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("What is the price?");
                    int userPrice = Integer.parseInt(bufferedReader.readLine());

                    CD userCD = new CD(userAristName, userAlbumnName, userReleaseYear, userPrice);

                    allCDs.add(userCD);

                    System.out.println("Alright, here's your new vehicle:");
                    System.out.println("----------------------");
                    System.out.println(userCD.artistName);
                    System.out.println(userCD.albumName);
                    System.out.println(userCD.releaseYear);
                    System.out.println(userCD.price);

                } else if (navigationChoice.equals("Exit")) {
                    System.out.println("Goodbye!");
                    programRunning = false;

                } else {
                    System.out.println("I'm sorry, we don't recognize your input");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}