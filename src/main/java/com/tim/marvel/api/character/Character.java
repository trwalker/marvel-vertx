package com.tim.marvel.api.character;

import lombok.Getter;

public class Character {

    @Getter
    private String name;

    public Character(String name) {
        this.name = name;
    }
}
