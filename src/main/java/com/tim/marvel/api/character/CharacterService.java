package com.tim.marvel.api.character;

import com.google.inject.Inject;

public class CharacterService {

    @Inject
    public CharacterService() {

    }

    public Character GetCharacter(String name) {
        return new Character(name);
    }
}
