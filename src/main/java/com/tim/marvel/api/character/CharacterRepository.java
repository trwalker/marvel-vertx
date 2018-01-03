package com.tim.marvel.api.character;

import com.tim.marvel.api.auth.Credentials;
import io.vertx.core.Handler;

public interface CharacterRepository {
    void getCharacter(int id, Credentials credentials, Handler<CharacterResult> callback);
}
