package com.zelling.screen_sound.main;

import com.zelling.screen_sound.models.Album;
import com.zelling.screen_sound.models.Artist;
import com.zelling.screen_sound.repository.AlbumRepository;
import com.zelling.screen_sound.repository.ArtistRepository;
import com.zelling.screen_sound.repository.SongRepository;
import com.zelling.screen_sound.utils.UI;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private AlbumRepository albumRepository;
    private UI ui = new UI();

    public Main(SongRepository songRepository, ArtistRepository artistRepository, AlbumRepository albumRepository){
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    public void App(){
        int menuOption = 1;

        while(menuOption != 0){
            ui.createMenu();
            menuOption = readInt();

            switch (menuOption){
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
                    System.out.println("\nInvalid option, please select a valid one");
            }
        }


    }

    private Optional<Artist> registerArtist(){
        ui.optionInput("Type artist name");
        var artistName = scanner.nextLine();

        ui.optionInput("Type artist type(Solo/Duo/Band/Group):");
        var artistType = scanner.nextLine();

        var artist = new Artist(artistName, artistType);

        try{
            artistRepository.save(artist);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create artist");
        }

        return Optional.of(artist);
    }

    public void registerAlbum(){
        ui.optionInput("type name of the album");
        var albumName = scanner.nextLine();

        ui.optionInput("type name of the artist:");
        var artistName = scanner.nextLine();

        var artistResult = artistRepository.findByNameContainsIgnoreCase(artistName);
        System.out.println(artistResult.isPresent());

        if(artistResult.isPresent()){
            var album = new Album(albumName,artistResult.get());
            albumRepository.save(album);
        } else{
            ui.separatorWithText("artist not found, creating new artist");
            var createdArtist = registerArtist();
            var album = new Album(artistName, createdArtist.get());
            albumRepository.save(album);
        }

        ui.separatorWithText("Album registered");
    }

    public void registerSong(){
        System.out.println("Main.registerSong");
    }

    private void listSongs(){
        System.out.println("Main.listSongs");
    }

    private void searchSongsByArtist(){
        System.out.println("Main.searchSongsByArtist");
    }

    private void findAboutArtist(){
        System.out.println("Main.findAboutArtist");
    }

    private int readInt(){
        var intValue = scanner.nextInt();
        scanner.nextLine();

        return intValue;
    }
}
