package com.zelling.screen_sound.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Artist artist;
    @ManyToOne
    private List<Song> songList;
}
