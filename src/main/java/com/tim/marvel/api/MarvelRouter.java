package com.tim.marvel.api;

import com.tim.marvel.api.character.CharacterHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import javax.inject.Inject;

public class MarvelRouter {

    private final Vertx vertx;
    private final CharacterHandler characterHandler;

    @Inject
    public MarvelRouter(
        Vertx vertx,
        CharacterHandler characterHandler) {
        this.vertx = vertx;
        this.characterHandler = characterHandler;
    }

    public Router buildRouter() {
        Router router = Router.router(vertx);

        router.route("/v1/character/:name").handler(characterHandler::getCharacter);
        router.route("/v1/character").handler(characterHandler::getCharacterList);

        return router;
    }
}
