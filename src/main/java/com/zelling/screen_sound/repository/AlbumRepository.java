package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Album;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByTitleContainsIgnoreCase(String title);
}
