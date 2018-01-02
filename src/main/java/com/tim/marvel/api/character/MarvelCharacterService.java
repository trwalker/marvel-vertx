package com.tim.marvel.api.character;

import com.google.inject.Inject;

public class MarvelCharacterService implements CharacterService {
    @Inject
    public MarvelCharacterService() {

    }

    public Character getCharacter(String name) {
        return new Character(name);
    }

    public Character[] getCharaterList() {
        return new Character[] { new Character("foo"), new Character("bar")};
    }
}
