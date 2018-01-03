package com.tim.marvel.api.character;

import io.vertx.core.Handler;

public interface CharacterService {

    void getCharacter(String name, Handler<Character> callback);

    void getCharaterList(Handler<Character[]> callback);
}
