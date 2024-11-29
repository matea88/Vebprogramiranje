package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums = new ArrayList<>();

@PostConstruct
    public void init(){
        artists.add(new Artist(1L, "Lana", "DelRay", "lanaBio"));
        artists.add(new Artist(2L, "Arctic", "Monkeys", "AMBio"));
        artists.add(new Artist(3L, "Joji", "Joji", "JojiBio"));
        artists.add(new Artist(4L, "Aca", "Lukas", "AcaBio"));
        artists.add(new Artist(5L, "Tose", "Proeski", "ToseBio"));

        Album a1 = new Album("Born to Die", "Rock", "2012");
        Album a2 = new Album("AM", "Indie Rock", "2013");
        Album a3 = new Album("Nectar", "Alt", "2020");
        Album a4 = new Album("Hitovi", "Srbsko", "2006");
        Album a5 = new Album("Po tebe", "Pop", "2005");

        songs.add(new Song("Norman Fucking Rockwell","Soft rock",2019, a1));
        songs.add(new Song("505","alternative/indie, Rock",2007, a2));
        songs.add(new Song("Ew","alternative/indie",2020, a3));
        songs.add(new Song("Volis li me","kafansko",2016, a4));
        songs.add(new Song("Ledena","ljubovna",2013, a5));

        albums.add(a1);
        albums.add(a2);
        albums.add(a3);
        albums.add(a4);
        albums.add(a5);
    }
}
