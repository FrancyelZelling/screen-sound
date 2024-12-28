package com.zelling.screen_sound.models;

public enum ArtistType {
    SOLO("single", "solo"),
    DUO("duo", "dupla"),
    BAND("band", "banda"),
    GROUP("group","grupo");

    private String artistType;
    private String artistTypeBR;

    ArtistType(String artistType, String artistTypeBR) {
        this.artistType = artistType;
        this.artistTypeBR = artistTypeBR;
    }
}
