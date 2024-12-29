package com.zelling.screen_sound.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private ArtistType artistType;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Album> albunsList = new ArrayList<>();

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Song> songList = new ArrayList<>();

    public Artist(){};
    public Artist(String name, String artistType){
        this.name = name;
        this.artistType = ArtistType.fromText(artistType);
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistType getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistType artistType) {
        this.artistType = artistType;
    }

    public List<Album> getAlbunsList() {
        return albunsList;
    }

    public void setAlbunsList(List<Album> albunsList) {
        this.albunsList = albunsList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public List<Song> addSong(Song song) {
        this.songList.add(song);
        return this.songList;
    }

    public List<Album> addAlbum(Album album) {
        this.albunsList.add(album);
        return this.albunsList;
    }

    @Override
    public String toString(){
        return "name:" + this.name + ", type: " + this.artistType;
    }
}
