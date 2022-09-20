package com.example.dao;

import com.example.data.Playlist;
import com.example.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao {
    public void insertIntoPlaylist(Playlist playlist) throws SQLException, ClassNotFoundException {
        int rows;
        Connection connection = DbConnection.getConnection();
        String sql = "Insert into playlist (playlist_name) values(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, playlist.getPlaylistName());
        rows = preparedStatement.executeUpdate();
        if(rows == 1){
            System.out.println("Inserted data");
        }
    }
    public List<Playlist> getPlaylistDetails() throws SQLException, ClassNotFoundException {
        List<Playlist> playlists = new ArrayList<>();
        Playlist playlist;
        Connection connection = DbConnection.getConnection();
        String sql = "Select playlist_id, playlist_name from playlist";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            playlist = new Playlist();
            playlist.setPlaylistID(resultSet.getInt(1));
            playlist.setPlaylistName(resultSet.getString(2));
            playlists.add(playlist);
        }
        return playlists;
    }
    public String getPlaylistContent(int id) throws SQLException, ClassNotFoundException {
        String content = null;
        Connection connection = DbConnection.getConnection();
        String sql = "Select playlist_content from playlist where playlist_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next())
            content = resultSet.getString(1);
        else
            System.out.println("Not found");
        return content;
    }

    public void deletePlaylist(int id) throws SQLException, ClassNotFoundException {
        int rows;
        Connection connection = DbConnection.getConnection();
        String sql = "Delete from playlist where playlist_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        rows = preparedStatement.executeUpdate();
        if(rows == 1){
            System.out.println("Deleted");
        }
    }

    public void updatePlaylist(int songId, int playlistId) throws SQLException, ClassNotFoundException {
        int rows;
        Connection connection = DbConnection.getConnection();
        String sql = "update playlist set playlist_content = concat(playlist_content, ?) where playlist_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, songId +", ");
        preparedStatement.setInt(2, playlistId);
        rows = preparedStatement.executeUpdate();
        if(rows == 1)
            System.out.println("Added to playlist");
    }
}
