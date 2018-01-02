package com.tim.marvel.api.character;

public interface CharacterService {

    Character getCharacter(String name);

    Character[] getCharaterList();
}
