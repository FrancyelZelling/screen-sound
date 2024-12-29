package com.zelling.screen_sound;

import com.zelling.screen_sound.main.Main;
import com.zelling.screen_sound.repository.AlbumRepository;
import com.zelling.screen_sound.repository.ArtistRepository;
import com.zelling.screen_sound.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundApplication implements CommandLineRunner {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private SongRepository songRepository;

    public static void main(String[] args) {
        SpringApplication.run(ScreenSoundApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main(artistRepository, albumRepository, songRepository);
        main.App();
    }
}
