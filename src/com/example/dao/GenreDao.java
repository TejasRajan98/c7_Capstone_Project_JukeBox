package com.example.dao;

import com.example.data.Genre;
import com.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    public int checkAndGetGGenreId(Genre genre) throws SQLException, ClassNotFoundException {
        int genreId = 0;
        Connection connection = DbConnection.getConnection();
        String sql = "Select genre_id from genre where genre_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, genre.getGenreName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            genreId = resultSet.getInt(1);
        }
        return genreId;
    }

    public List<Genre> checkAndGetGenreList() throws SQLException, ClassNotFoundException {
        List<Genre> genreList = new ArrayList<>();
        Genre genre = new Genre();
        Connection connection = DbConnection.getConnection();
        String sql = "Select genre_id, genre_name from genre";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            genre.setGenreID(resultSet.getInt(1));
            genre.setGenreName(resultSet.getString(2));
            genreList.add(genre);
        }
        return genreList;
    }
}
