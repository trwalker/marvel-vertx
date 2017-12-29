package com.tim.marvel.api;

import com.tim.marvel.api.handlers.GetCharacterHandler;
import com.tim.marvel.api.handlers.GetCharacterListHandler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

import javax.inject.Inject;

public class MarvelRouter {

    private final Vertx vertx;
    private final GetCharacterHandler getCharacterHandler;
    private final GetCharacterListHandler getCharacterListHandler;

    @Inject
    public MarvelRouter(
        Vertx vertx,
        GetCharacterHandler getCharacterHandler,
        GetCharacterListHandler getCharacterListHandler) {
        this.vertx = vertx;
        this.getCharacterHandler = getCharacterHandler;
        this.getCharacterListHandler = getCharacterListHandler;
    }

    public Router buildRouter() {
        Router router = Router.router(vertx);

        router.route("/v1/character/:name").handler(getCharacterHandler::getCharacter);
        router.route("/v1/character").handler(getCharacterListHandler::getCharacterList);

        return router;
    }
}
