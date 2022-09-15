package com.example.main;

import com.example.dao.ArtistDao;
import com.example.dao.GenreDao;
import com.example.dao.SongsDao;
import com.example.data.Artist;
import com.example.data.Genre;
import com.example.data.Songs;

import java.sql.SQLException;

public class JukeboxMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int artistId;
        int genreId;
        int songId;

        Artist artist = new Artist();
        Genre genre = new Genre();
        Songs songs = new Songs();

        ArtistDao artistDao = new ArtistDao();
        GenreDao genreDao = new GenreDao();
        SongsDao songsDao = new SongsDao();

        artist.setArtistName("Taylor");
        genre.setGenreName("Pop");
        songs.setNameOfSong("Blank Space");

        artistId = artistDao.checkAndGetArtistId(artist);
        genreId = genreDao.checkAndGetGGenreId(genre);
        songId = songsDao.checkAndGetSongID(songs);

        System.out.println("artistId = " + artistId);
        System.out.println("genreId = " + genreId);
        System.out.println("songId = " + songId);
    }
}
