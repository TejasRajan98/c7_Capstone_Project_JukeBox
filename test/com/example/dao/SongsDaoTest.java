package com.example.dao;

import com.example.data.Songs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongsDaoTest {

    SongsDao songsDao;
    List<Songs> songsList;
    String songRoot;
    int[] songIds;
    @BeforeEach
    void setUp() {
        songsDao = new SongsDao();
        songIds = new int[]{2, 3, 5};
    }

    @AfterEach
    void tearDown() {
        songsDao = null;
        songsList = null;
        songRoot = null;
        songIds = null;
    }

    @Test
    void checkSongAndGetList() throws SQLException, ClassNotFoundException {
        songsList = songsDao.checkSongAndGetList("H");
        int expectedValue = 1;
        int actualValue = songsList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void checkGenreAndGetList() throws SQLException, ClassNotFoundException {
        songsList = songsDao.checkGenreAndGetList("Pop");
        int expectedValue = 2;
        int actualValue = songsList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void checkArtistAndGetList() throws SQLException, ClassNotFoundException {
        songsList = songsDao.checkArtistAndGetList("AC/DC");
        int expectedValue = 1;
        int actualValue = songsList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void getAllDetailsOfSongsList() throws SQLException, ClassNotFoundException {
        songsList = songsDao.getAllDetailsOfSongsList();
        int expectedValue = 8;
        int actualValue = songsList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void checkIdAndGetSong() throws SQLException, ClassNotFoundException {
        songRoot = songsDao.checkIdAndGetSongRoot(3);
        String expectedValue = "resources/rock/Back In Black.wav";
        String actualValue = songRoot;
        assertEquals(expectedValue, actualValue);
        assertNotEquals(null, actualValue);
    }

    @Test
    void checkIdAndGetSongRoot() throws SQLException, ClassNotFoundException {
        songsList = songsDao.getSongsList(songIds);
        int expectedValue = 3;
        int actualValue = songsList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void checkIdAndGetSongName() throws SQLException, ClassNotFoundException {
        String songName = songsDao.checkIdAndGetSongName(3);
        String expectedValue = "Back in Black";
        String actualValue = songName;
        assertEquals(expectedValue, actualValue);
        assertNotEquals(null, actualValue);
    }
}