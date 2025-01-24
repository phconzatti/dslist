package com.dslist.dto;

import com.dslist.entities.GameList;

public class GameListDTO {

    private long id;
    private String name;

    public GameListDTO(){

    }


    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }


    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

}
