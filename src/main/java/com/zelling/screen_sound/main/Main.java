package com.zelling.screen_sound.main;

import com.zelling.screen_sound.utils.UI;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public void App(){
        UI ui = new UI();
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
                case 0:
                    System.out.println("\nExiting...");
                    break;
                default:
                    System.out.println("\nInvalid option, please select a valid one");
            }
        }


    }

    private void registerArtist(){
        System.out.println("Main.registerArtist");
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
