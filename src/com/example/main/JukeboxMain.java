package com.example.main;

import com.example.dao.ArtistDao;
import com.example.dao.GenreDao;
import com.example.dao.SongsDao;
import com.example.data.Artist;
import com.example.data.Genre;
import com.example.data.Songs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class JukeboxMain {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int artistId;
        int genreId;
        int songId;
        int choice;

        Artist artist = new Artist();
        Genre genre = new Genre();
        Songs songs = new Songs();

        ArtistDao artistDao = new ArtistDao();
        GenreDao genreDao = new GenreDao();
        SongsDao songsDao = new SongsDao();

        System.out.println("\nWelcome to Jukebox\n");
        do{
            System.out.println("Search based on");
            System.out.println("1. Name of song");
            System.out.println("2. Genre of song");
            System.out.println("3. Artist of song\n");
            System.out.println("4. View song list");
            System.out.println("5. Create or view playlist");
            System.out.println("6. Jukebox operations");
            System.out.println("7. Exit");
            System.out.println("\nEnter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    searchName(songsDao);
                    break;
                case 2:
                    //searchGenre(genreDao, songsDao);
                    break;
                case 3:
                    searchArtist();
                    break;
                case 4:
                    viewAllSongs();
                    break;
                case 5:
                    playlist();
                    break;
                case 6:
                    jukeboxOperations();
                    break;
                case 7:
                    System.out.println("Exiting\n");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        }while(choice != 7);

        /*artist.setArtistName("Taylor");
        genre.setGenreName("Pop");
        songs.setNameOfSong("Blank Space");

        artistId = artistDao.checkAndGetArtistId(artist);
        genreId = genreDao.checkAndGetGGenreId(genre);
        songId = songsDao.checkAndGetSongID(songs);

        System.out.println("artistId = " + artistId);
        System.out.println("genreId = " + genreId);
        System.out.println("songId = " + songId);*/
    }

    private static void searchName(SongsDao songsDao) throws SQLException, ClassNotFoundException {
        int choice;
        System.out.println("Enter song name: ");
        String name = sc.nextLine();
        int songId;
        List<Songs> songList = songsDao.checkSongAndGetResult(name);
        Iterator<Songs> iterator = songList.iterator();
        while (iterator.hasNext()){
            Songs element = iterator.next();
            songId = element.getSongID();
            name = element.getNameOfSong();
            System.out.println("Song ID: " + songId + " Song name: " + name);
        }
        System.out.println("Enter song id: ");
        songId = sc.nextInt();
        do {
            System.out.println("\n1. Play/Pause \n2. Add to playlist \n3. Go back \nEnter choice: ");
            choice = sc.nextInt();
            if (choice == 1)
                System.out.println("Playing song");
            else if (choice == 2)
                System.out.println("Added to playlist");
            else if (choice == 3)
                System.out.println("Going back");
        }
        while(choice != 3);
    }

   /* private static void searchGenre(GenreDao genreDao, SongsDao songsDao){
        int choice;
        System.out.println("Enter genre name: ");
        String name = sc.nextLine();
        int genreId;
        List<Songs> genreList = songsDao.checkSongAndGetResult(name);
        Iterator<Songs> iterator = genreList.iterator();
        while (iterator.hasNext()){
            genreId = iterator.next().getSongID();
            name = iterator.next().getNameOfSong();
            System.out.println("Song ID: " + genreId + " Song name: " + name);
        }
        System.out.println("Enter song id: ");
        genreId = sc.nextInt();
        do {
            System.out.println("\n1. Play/Pause \n2. Add to playlist \n3. Go back \nEnter choice: ");
            choice = sc.nextInt();
            if (choice == 1)
                System.out.println("Playing song");
            else if (choice == 2)
                System.out.println("Added to playlist");
            else if (choice == 3)
                System.out.println("Going back");
        }
        while(choice != 3);
    }*/

    private static void searchArtist() {
    }

    private static void viewAllSongs() {
    }

    private static void playlist() {
    }

    private static void jukeboxOperations() {
    }
}
