package com.example.dao;

import com.example.data.Artist;
import com.example.data.Genre;
import com.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {
    public List<Artist> checkAndGetArtistList() throws SQLException, ClassNotFoundException {
        List<Artist> artistList = new ArrayList<>();
        Artist artist;
        Connection connection = DbConnection.getConnection();
        String sql = "Select artist_id, artist_name from artist";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            artist = new Artist();
            artist.setArtistID(resultSet.getInt(1));
            artist.setArtistName(resultSet.getString(2));
            artistList.add(artist);
        }
        return artistList;
    }
}
