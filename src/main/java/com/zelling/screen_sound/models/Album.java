package com.zelling.screen_sound.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String title;
    private Artist artist;
    @ManyToOne(targetEntity = Song.class)
    private List<Song> songList;

    public Album(){};
}
