package com.example.data;

public class Songs {

    private int songID;
    private String nameOfSong;
    private Artist artist;
    private Genre genre;
    private String duration;
    private int year;
    private String path;

    public Songs() {
    }

    public Songs(int songID, String nameOfSong, Artist artist, Genre genre, String duration, int year, String path) {
        this.songID = songID;
        this.nameOfSong = nameOfSong;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.year = year;
        this.path = path;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getNameOfSong() {
        return nameOfSong;
    }

    public void setNameOfSong(String nameOfSong) {
        this.nameOfSong = nameOfSong;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songID=" + songID +
                ", nameOfSong='" + nameOfSong + '\'' +
                ", artist=" + artist +
                ", genre=" + genre +
                ", duration='" + duration + '\'' +
                ", year=" + year +
                ", path='" + path + '\'' +
                '}';
    }
}
