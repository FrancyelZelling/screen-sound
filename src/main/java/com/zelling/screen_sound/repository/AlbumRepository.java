package com.zelling.screen_sound.repository;

import com.zelling.screen_sound.models.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
