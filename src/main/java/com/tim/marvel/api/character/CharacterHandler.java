package com.tim.marvel.api.character;

import com.google.inject.Inject;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;

public class CharacterHandler {

    private final CharacterService characterService;

    @Inject
    public CharacterHandler(CharacterService characterService) {
        this.characterService = characterService;
    }

    public void getCharacter(RoutingContext context) {
        String name = context.request().getParam("name");
        Character character = characterService.getCharacter(name);

        context.response()
            .putHeader("content-type", "application/json")
            .end(Json.encode(character));
    }

    public void getCharacterList(RoutingContext context) {

        Character[] characters = characterService.getCharaterList();

        context.response()
                .putHeader("content-type", "application/json")
                .end(Json.encode(characters));
    }
}
