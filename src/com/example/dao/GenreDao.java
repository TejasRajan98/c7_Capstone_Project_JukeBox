package com.example.dao;

import com.example.data.Genre;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
