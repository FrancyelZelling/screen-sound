package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepository extends JpaRepository<Song, Long> {
    Optional<Song> findByNameContainsIgnoreCase(String songName);

    @Query("SELECT s FROM Artist a JOIN a.songList s WHERE a.id=:id")
    List<Song> findByArtistId(Long id);
}
