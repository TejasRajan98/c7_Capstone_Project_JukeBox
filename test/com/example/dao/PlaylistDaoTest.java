package com.example.dao;

import com.example.data.Playlist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistDaoTest {

    PlaylistDao playlistDao;
    List<Playlist> playlists;
    String content;
    @BeforeEach
    void setUp() {
        playlistDao = new PlaylistDao();
    }

    @AfterEach
    void tearDown() {
        playlistDao = null;
        playlists = null;
    }

    @Test
    void getPlaylistDetails() throws SQLException, ClassNotFoundException {
        playlists = playlistDao.getPlaylistDetails();
        int expectedValue = 1;
        int actualValue = playlists.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }

    @Test
    void getPlaylistContent() throws SQLException, ClassNotFoundException {
        content = "1, 3, 7, ";
        String expectedValue = content;
        String actualValue = playlistDao.getPlaylistContent(1);
        assertEquals(expectedValue, actualValue);
        assertNotEquals(null, actualValue);
    }
}