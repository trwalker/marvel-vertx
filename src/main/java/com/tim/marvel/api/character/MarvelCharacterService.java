package com.tim.marvel.api.character;

import com.google.inject.Inject;
import com.tim.marvel.api.auth.Credentials;
import io.vertx.core.Handler;

public class MarvelCharacterService implements CharacterService {

    private final CharacterRepository characterRepository;

    @Inject
    public MarvelCharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public void getCharacter(String name, Handler<Character> callback) {
        int id = CharacterMap.getCharacterIdByName(name);
        characterRepository.getCharacter(id, new Credentials("", "", ""), result -> {
            if(result != null) {
                System.out.println(result.getResponseCode());
                System.out.println(result.getError() == null ? "no error" : result.getError());
            }


            callback.handle(new Character(name));
        });
    }

    public void getCharaterList(Handler<Character[]> callback) {
        callback.handle(new Character[] { new Character("foo"), new Character("bar")});
    }
}
