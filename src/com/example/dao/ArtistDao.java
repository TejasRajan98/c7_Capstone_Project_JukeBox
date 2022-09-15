package com.example.dao;

import com.example.data.Artist;
import com.example.data.Genre;
import com.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Artist> checkAndGetArtistList() throws SQLException, ClassNotFoundException {
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist();
        Connection connection = DbConnection.getConnection();
        String sql = "Select artist_id, artist_name from artist";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            artist.setArtistID(resultSet.getInt(1));
            artist.setArtistName(resultSet.getString(2));
            artistList.add(artist);
        }
        return artistList;
    }
}
