package com.example.dao;

import com.example.data.Genre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreDaoTest {

    GenreDao genreDao;
    List<Genre> genreList;
    @BeforeEach
    void setUp() {
        genreDao = new GenreDao();
    }

    @AfterEach
    void tearDown() {
        genreDao = null;
        genreList = null;
    }

    @Test
    void checkAndGetGenreList() throws SQLException, ClassNotFoundException {
        genreList = genreDao.checkAndGetGenreList();
        int expectedValue = 4;
        int actualValue = genreList.size();
        assertEquals(expectedValue, actualValue);
        assertNotEquals(10, actualValue);
    }
}