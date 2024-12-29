package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Album;
import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainsIgnoreCase(String name);
//
//    @Query("SELECT album FROM Artist artist JOIN artist.albumsList WHERE album.title ILIKE %:albumName%")
//    Optional<Album> findAlbum(String albumName);
//
//    @Query("SELECT song FROM Artist artist JOIN artist.songList WHERE song.name ILIKE %:songName%")
//    Optional<Song> findSong(String songName);
//
//    @Query("SELECT song FROM Artist artist JOIN artist.songList")
//    List<Song> findAllSongs();
}
