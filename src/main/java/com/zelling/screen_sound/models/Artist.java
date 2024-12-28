package com.zelling.screen_sound.models;

import jakarta.persistence.*;

import java.io.Serializable;
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
    private List<Album> albunsList;

    @OneToMany(
            mappedBy = "artist",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Song> songList;

    public Artist(){};
}
