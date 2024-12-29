package com.zelling.screen_sound.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(unique = true)
    private String title;

    @ManyToOne
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private List<Song> songList = new ArrayList<>();

    public Album() {}

    public Album(String title, Artist artist) {
        this.title = title;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public List<Song> addSong(Song song) {
        this.songList.add(song);
        return this.songList;
    }

    @Override
    public String toString() {
        return (
            "title: " +
            title +
            ", artist: " +
            artist +
            ", songList: " +
            songList
        );
    }
}
