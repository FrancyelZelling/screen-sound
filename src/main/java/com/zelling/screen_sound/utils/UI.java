package com.zelling.screen_sound.utils;

public class UI {

    public void createMenu(){
        System.out.println(
                """
                
                **********  Menu Principal  **********
                
                1 - Cadastrar artistas
                2 - Cadastrar músicas
                3 - Listar Músicas
                4 - Buscar músicas por artistas
                5 - Pesquisar dados sobre um artista
                
                0 - Sair
                
                """
        );
    }

    public void optionInput(String text){
        System.out.printf(
                """
                \n ***** %s ***** \n
                """, text
        );
    }

    public void separatorWithText(String text){
        System.out.printf(
                """
                
                **********  %s  ***********
                
                """,text
        );
    }
}
