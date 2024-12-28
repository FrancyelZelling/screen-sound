package com.zelling.screen_sound.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ArtistType artistType;
    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Album> albunsList;
    @OneToMany(
            mappedBy = "song",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Song> songList;
}
