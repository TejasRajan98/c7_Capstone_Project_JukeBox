package com.example.dao;

import com.example.data.Songs;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongsDao {
    public int checkAndGetSongID(Songs songs) throws SQLException, ClassNotFoundException {
        int songId = 0;
        Connection connection = DbConnection.getConnection();
        String sql = "Select song_id from songs where song_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, songs.getNameOfSong());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            songId = resultSet.getInt(1);
        }
        return songId;
    }
}
