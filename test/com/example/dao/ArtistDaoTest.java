package com.example.dao;

import com.example.data.Artist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistDaoTest {

    ArtistDao artistDao;
    List<Artist> artistList;
    @BeforeEach
    void setUp() {
        artistDao = new ArtistDao();
    }

    @AfterEach
    void tearDown() {
        artistDao = null;
        artistList = null;
    }

    @Test
    void checkAndGetArtistList() throws SQLException, ClassNotFoundException {
        artistList = artistDao.checkAndGetArtistList();
        int expectedValue = 7;
        int acutalValue = artistList.size();
        assertEquals(expectedValue, acutalValue);
        assertNotEquals(10, acutalValue);
    }
}