package com.tim.marvel.api.character;

import io.vertx.core.json.JsonObject;
import lombok.Getter;

public class CharacterResult {

    @Getter
    private int responseCode;

    @Getter
    private JsonObject characterData;

    @Getter
    private Exception error;

    public CharacterResult(int responseCode, JsonObject characterData, Exception error) {
        this.responseCode = responseCode;
        this.characterData = characterData;
        this.error = error;
    }
}
