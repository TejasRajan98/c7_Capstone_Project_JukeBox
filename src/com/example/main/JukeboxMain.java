package com.example.main;

import com.example.dao.ArtistDao;
import com.example.dao.GenreDao;
import com.example.dao.SongsDao;
import com.example.data.Artist;
import com.example.data.Genre;
import com.example.data.Songs;

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
            System.out.println("\nSearch based on");
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
                    searchGenre(genreDao, songsDao);
                    break;
                case 3:
                    searchArtist(artistDao, songsDao);
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
    }

    private static void searchName(SongsDao songsDao) throws SQLException, ClassNotFoundException {
        int choice;
        String choice2;
        System.out.println("\nEnter song name: ");
        String name = sc.nextLine();
        int songId;
        List<Songs> songList = songsDao.checkSongAndGetList(name);
        do {
            printSongList(songList);
            System.out.println("\nEnter song id: ");
            songId = sc.nextInt();
            System.out.println("\n1. Play/Pause \n2. Add to playlist \n3. Go back \nEnter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1)
                System.out.println("Playing song");
            else if (choice == 2)
                System.out.println("Added to playlist");
            else if (choice == 3) {
                System.out.println("Going back");
                break;
            }
            System.out.println("\nDo you want to continue? Enter Yes");
            choice2 = sc.nextLine();
        }
        while(choice2.equals("Yes"));
    }

    private static void searchGenre(GenreDao genreDao, SongsDao songsDao) throws SQLException, ClassNotFoundException {
        int choice;
        String choice2;
        String name = null;
        List<Genre> genreList = genreDao.checkAndGetGenreList();
        for(Genre genre: genreList){
            System.out.println("\n" + genre.getGenreID() + ". " + genre.getGenreName());
        }
        System.out.println("\nEnter choice of genre: ");
        choice = sc.nextInt();
        for(Genre genre: genreList){
            if(genre.getGenreID() == choice)
                name = genre.getGenreName();
        }
        System.out.println("\nSongs of selected genre: ");
        List<Songs> songList = songsDao.checkGenreAndGetList(name);
        int songId;
        do {
            printSongList(songList);
            System.out.println("\nEnter song id: ");
            songId = sc.nextInt();
            System.out.println("\n1. Play/Pause \n2. Add to playlist \n3. Go back \nEnter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1)
                System.out.println("Playing song");
            else if (choice == 2)
                System.out.println("Added to playlist");
            else if (choice == 3) {
                System.out.println("Going back");
                break;
            }
            System.out.println("\nDo you want to continue? Enter Yes");
            choice2 = sc.nextLine();
        }
        while(choice2.equals("Yes"));
    }

    private static void printSongList(List<Songs> songList) {
        System.out.format("%-10s %-30s\n","Song ID", "Song Name");
        for(Songs songs : songList){
            System.out.format("%-10d %-30s\n", songs.getSongID(), songs.getNameOfSong());
        }
    }

    private static void searchArtist(ArtistDao artistDao, SongsDao songsDao) throws SQLException, ClassNotFoundException {
        int choice;
        String choice2;
        String name = null;
        List<Artist> artistList = artistDao.checkAndGetArtistList();
        for(Artist artist: artistList){
            System.out.println("\n" + artist.getArtistID() + ". " + artist.getArtistName());
        }
        System.out.println("\nEnter choice of artist: ");
        choice = sc.nextInt();
        for(Artist artist: artistList){
            if(artist.getArtistID() == choice)
                name = artist.getArtistName();
        }
        System.out.println("\nSongs of artist " + name + ": ");
        List<Songs> songList = songsDao.checkArtistAndGetList(name);
        int songId;
        do {
            printSongList(songList);
            System.out.println("\nEnter song id: ");
            songId = sc.nextInt();
            System.out.println("\n1. Play/Pause \n2. Add to playlist \n3. Go back \nEnter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1)
                System.out.println("Playing song");
            else if (choice == 2)
                System.out.println("Added to playlist");
            else if (choice == 3) {
                System.out.println("Going back");
                break;
            }
            System.out.println("\nDo you want to continue? Enter Yes");
            choice2 = sc.nextLine();
        }
        while(choice2.equals("Yes"));
    }

    private static void viewAllSongs() {
    }

    private static void playlist() {
    }

    private static void jukeboxOperations() {
    }
}
