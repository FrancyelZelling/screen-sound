package com.zelling.screen_sound.models;

import jakarta.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;

    public Song(){};
}
