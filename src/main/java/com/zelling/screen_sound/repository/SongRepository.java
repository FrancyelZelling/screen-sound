package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
