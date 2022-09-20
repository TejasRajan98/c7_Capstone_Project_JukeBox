package com.example.data;

public class Playlist {
    private int playlistID;
    private String playlistName;
    private String playlistContent;

    public Playlist() {
    }

    public Playlist(int playlistID, String playlistName, String playlistContent) {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
        this.playlistContent = playlistContent;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistContent() {
        return playlistContent;
    }

    public void setPlaylistContent(String playlistContent) {
        this.playlistContent = playlistContent;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistID=" + playlistID +
                ", playlistName='" + playlistName + '\'' +
                ", playlistContent='" + playlistContent + '\'' +
                '}';
    }
}
