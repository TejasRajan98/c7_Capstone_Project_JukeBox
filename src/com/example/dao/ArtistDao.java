package com.example.dao;

import com.example.data.Artist;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDao {
    public int checkAndGetArtistId(Artist artist) throws SQLException, ClassNotFoundException {
        int artistId = 0;
        Connection connection = DbConnection.getConnection();
        String sql = "Select artist_id from artist where artist_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, artist.getArtistName());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            artistId = resultSet.getInt(1);
        }
        return artistId;
    }
}
