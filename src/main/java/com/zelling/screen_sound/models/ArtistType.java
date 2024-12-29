package com.zelling.screen_sound.models;

public enum ArtistType {
    SOLO("single", "solo"),
    DUO("duo", "dupla"),
    BAND("band", "banda"),
    GROUP("group", "grupo");

    private String artistType;
    private String artistTypeBR;

    ArtistType(String artistType, String artistTypeBR) {
        this.artistType = artistType;
        this.artistTypeBR = artistTypeBR;
    }

    public static ArtistType fromText(String text) {
        for (ArtistType artistType : ArtistType.values()) {
            if (artistType.artistType.equalsIgnoreCase(text)) {
                return artistType;
            } else if (artistType.artistTypeBR.equalsIgnoreCase(text)) {
                return artistType;
            }
        }
        throw new IllegalArgumentException(
            "Nenhuma categoria encontrada para a string fornecida: "
        );
    }
}
