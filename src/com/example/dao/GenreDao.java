package com.example.dao;

import com.example.data.Genre;
import com.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    public List<Genre> checkAndGetGenreList() throws SQLException, ClassNotFoundException {
        List<Genre> genreList = new ArrayList<>();
        Genre genre;
        Connection connection = DbConnection.getConnection();
        String sql = "Select genre_id, genre_name from genre";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            genre = new Genre();
            genre.setGenreID(resultSet.getInt(1));
            genre.setGenreName(resultSet.getString(2));
            genreList.add(genre);
        }
        return genreList;
    }
}
