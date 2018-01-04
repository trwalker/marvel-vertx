package com.tim.marvel.api.character;

import com.google.inject.Inject;
import com.tim.marvel.api.auth.Credentials;
import com.tim.marvel.api.config.ConfigService;
import io.vertx.core.Handler;

public class MarvelCharacterService implements CharacterService {

    private final ConfigService configService;
    private final CharacterRepository characterRepository;

    @Inject
    public MarvelCharacterService(
            ConfigService configService,
            CharacterRepository characterRepository) {
        this.configService = configService;
        this.characterRepository = characterRepository;
    }

    public void getCharacter(String name, Handler<Character> callback) {
        int id = CharacterMap.getCharacterIdByName(name);
        configService.getConfig(config -> {
            characterRepository.getCharacter(id, new Credentials("", "", ""), result -> {
                if(result != null) {

                }

                callback.handle(new Character(name));
            });
        });
    }

    public void getCharaterList(Handler<Character[]> callback) {
        callback.handle(new Character[] { new Character("foo"), new Character("bar")});
    }
}
