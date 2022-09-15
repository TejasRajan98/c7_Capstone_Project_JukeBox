package com.example.dao;

import com.example.data.Songs;
import com.example.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Songs> checkSongAndGetList(String song) throws SQLException, ClassNotFoundException {
        List<Songs> songList = new ArrayList<>();
        Songs songs = new Songs();
        Connection connection = DbConnection.getConnection();
        String sql = "Select song_id, song_name from songs where song_name like ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, '%' + song + '%');
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            songs.setSongID(resultSet.getInt(1));
            songs.setNameOfSong(resultSet.getString(2));
            songList.add(songs);
        }
        return songList;
    }

    public List<Songs> checkGenreAndGetList(String name) throws SQLException, ClassNotFoundException {
        List<Songs> songList = new ArrayList<>();
        Songs songs = new Songs();
        Connection connection = DbConnection.getConnection();
        String sql = "Select song_id, song_name from songs where genre = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            songs.setSongID(resultSet.getInt(1));
            songs.setNameOfSong(resultSet.getString(2));
            songList.add(songs);
        }
        return songList;
    }

    public List<Songs> checkArtistAndGetList(String name) throws SQLException, ClassNotFoundException {
        List<Songs> songList = new ArrayList<>();
        Songs songs = new Songs();
        Connection connection = DbConnection.getConnection();
        String sql = "Select song_id, song_name from songs where artist = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            songs.setSongID(resultSet.getInt(1));
            songs.setNameOfSong(resultSet.getString(2));
            songList.add(songs);
        }
        return songList;
    }
}
