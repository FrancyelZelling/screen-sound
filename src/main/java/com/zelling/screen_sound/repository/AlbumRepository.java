package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Album;
import com.zelling.screen_sound.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByTitleContainsIgnoreCase(String title);
}
