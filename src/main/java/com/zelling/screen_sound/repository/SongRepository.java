package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByNameContainsIgnoreCase(String artistName);
}
