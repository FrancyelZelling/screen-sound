package com.zelling.screen_sound.main;

import com.zelling.screen_sound.models.Album;
import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.models.Song;
import com.zelling.screen_sound.repository.ArtistRepository;
import com.zelling.screen_sound.utils.UI;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private final ArtistRepository artistRepository;
    private final UI ui = new UI();

    public Main(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
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
//                    registerSong();
                    break;
                case 3:
//                    listSongs();
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
                    System.out.println("\nInvalid option, please select a valid one");
            }
        }
    }

    private Artist registerArtist() {
        ui.optionInput("Type artist name");
        var artistName = scanner.nextLine();
        var findArtist = artistRepository.findByNameContainsIgnoreCase(artistName);
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

        var artistFind = artistRepository.findByNameContainsIgnoreCase(artistInput);
        if (artistFind.isEmpty()) {
            ui.separatorWithText("artist not found, creating one...");
            artist = registerArtist();
        } else {
            artist = artistFind.get();
        }

        return artist;
    }

    public Album registerAlbum() {
        ui.optionInput("type name of the album");
        var albumName = scanner.nextLine();
//        var findAlbum = artistRepository.findAlbum(albumName);
        Album album;

        var artist = findArtist();

        album = new Album(albumName, artist);
        artist.addAlbum(album);

        artistRepository.save(artist);

        ui.separatorWithText("Album registered");
        return album;
//        if (findAlbum.isPresent()) {
//            ui.separatorWithText("album already exists");
//            return album = findAlbum.get();
//        } else {
//            var artist = findArtist();
//
//            album = new Album(albumName, artist);
//            artist.addAlbum(album);
//
//            artistRepository.save(artist);
//
//            ui.separatorWithText("Album registered");
//            return album;
//        }
    }

//    public Album findAlbum() {
//        ui.optionInput("type name of the album to search");
//        var albumName = scanner.nextLine();
//        var albumFind = artistRepository.findAlbum(albumName);
//        Album album;
//
//        if (albumFind.isEmpty()) {
//            ui.optionInput("album not found, creating one...");
//            album = registerAlbum();
//        } else {
//            album = albumFind.get();
//        }
//
//        return album;
//    }

//    public Song registerSong() {
//        ui.optionInput("type name of the song");
//        var songName = scanner.nextLine();
//
//        var findSong = artistRepository.findSong(songName);
//        if (findSong.isPresent()) {
//            ui.separatorWithText("song already exists");
//            return findSong.get();
//        } else {
//            var artist = findArtist();
//            var album = findAlbum();
//
//            var song = new Song(songName, artist);
//            song.setAlbum(album);
//            album.addSong(song);
//
//            artist.addAlbum(album);
//            artist.addSong(song);
//            artistRepository.save(artist);
//
//            ui.separatorWithText("Song registered");
//            return song;
//        }
//    }

//    private void listSongs() {
//        var songs = artistRepository.findAllSongs();
//        if (songs.isEmpty()){
//            ui.separatorWithText("cannot find songs");
//        }else {
//            songs.forEach(System.out::println);
//        }
//    }

    private void searchSongsByArtist() {
        System.out.println("Main.searchSongsByArtist");
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
