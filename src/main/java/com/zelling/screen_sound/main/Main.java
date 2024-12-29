package com.zelling.screen_sound.main;

import com.zelling.screen_sound.models.Album;
import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import com.zelling.screen_sound.repository.AlbumRepository;
import com.zelling.screen_sound.repository.ArtistRepository;
import com.zelling.screen_sound.repository.SongRepository;
import com.zelling.screen_sound.utils.UI;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final UI ui = new UI();

    public Main(
        ArtistRepository artistRepository,
        AlbumRepository albumRepository,
        SongRepository songRepository
    ) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
    }

    public void App() {
        int menuOption = 1;

        while (menuOption != 0) {
            ui.createMenu();
            menuOption = readInt();

            switch (menuOption) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerSong();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchSongsByArtist();
                    break;
                case 5:
                    findAboutArtist();
                    break;
                case 6:
                    registerAlbum();
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println(
                        "\nInvalid option, please select a valid one"
                    );
            }
        }
    }

    private Artist registerArtist() {
        ui.optionInput("Type artist name");
        var artistName = scanner.nextLine();
        var findArtist = artistRepository.findByNameContainsIgnoreCase(
            artistName
        );
        Artist artist;

        if (findArtist.isPresent()) {
            ui.separatorWithText("artist already exists");
            return artist = findArtist.get();
        } else {
            ui.optionInput("Type artist type(Solo/Duo/Band/Group):");
            var artistType = scanner.nextLine();
            artist = new Artist(artistName, artistType);
            artistRepository.save(artist);
            return artist;
        }
    }

    public Artist findArtist() {
        ui.optionInput("type name of the artist to search");
        var artistInput = scanner.nextLine();
        Artist artist;

        var artistFind = artistRepository.findByNameContainsIgnoreCase(
            artistInput
        );
        if (artistFind.isEmpty()) {
            ui.separatorWithText("artist not found, creating one...");
            artist = registerArtist();
        } else {
            artist = artistFind.get();
        }

        return artist;
    }

    public Album registerAlbum() {
        Album album;
        ui.optionInput("type name of the album");
        var albumName = scanner.nextLine();
        var findAlbum = albumRepository.findByTitleContainsIgnoreCase(
            albumName
        );
        var artist = findArtist();

        if (findAlbum.isPresent()) {
            ui.separatorWithText("album already exists");
            return album = findAlbum.get();
        } else {
            album = new Album(albumName, artist);
            albumRepository.save(album);
            ui.separatorWithText("Album registered");
            return album;
        }
    }

    public Album findAlbum() {
        ui.optionInput("type name of the album to search");
        var albumName = scanner.nextLine();
        var albumFind = albumRepository.findByTitleContainsIgnoreCase(
            albumName
        );
        Album album;

        if (albumFind.isEmpty()) {
            ui.optionInput("album not found, creating one...");
            album = registerAlbum();
        } else {
            album = albumFind.get();
        }

        return album;
    }

    public Song registerSong() {
        ui.optionInput("type name of the song");
        var songName = scanner.nextLine();

        var findSong = songRepository.findByNameContainsIgnoreCase(songName);
        if (findSong.isPresent()) {
            ui.separatorWithText("song already exists");
            return findSong.get();
        } else {
            var artist = findArtist();
            var album = findAlbum();

            var song = new Song(songName, artist);
            song.setAlbum(album);

            songRepository.save(song);
            ui.separatorWithText("Song registered");
            return song;
        }
    }

    private void listSongs() {
        var songs = songRepository.findAll();
        if (songs.isEmpty()) {
            ui.separatorWithText("cannot find songs");
        } else {
            songs.forEach(s -> {
                System.out.println(
                    "Title: " +
                    s.getName() +
                    ", Artist: " +
                    s.getArtist().getName() +
                    ", Album: " +
                    s.getAlbum().getTitle()
                );
            });
        }
    }

    private void searchSongsByArtist() {
        ui.optionInput("type name of the artist");
        var artistName = scanner.nextLine();
        var findArtist = artistRepository.findByNameContainsIgnoreCase(
            artistName
        );

        if (findArtist.isPresent()) {
            var songList = songRepository.findByArtistId(
                findArtist.get().getId()
            );
            songList.forEach(s -> {
                System.out.println(
                    "Title: " +
                    s.getName() +
                    ", Artist: " +
                    s.getArtist().getName() +
                    ", Album: " +
                    s.getAlbum().getTitle()
                );
            });
        }
    }

    private void findAboutArtist() {
        System.out.println("Main.findAboutArtist");
    }

    private int readInt() {
        var intValue = scanner.nextInt();
        scanner.nextLine();

        return intValue;
    }
}
