package com.tim.marvel.api.character;

import io.vertx.ext.web.RoutingContext;

public class CharacterHandler {
    public void getCharacter(RoutingContext context) {
        context.response()
            .putHeader("content-type", "application/json")
            .end(String.format("{ \"name\": \"%s\" }", context.request().getParam("name")));
    }

    public void getCharacterList(RoutingContext context) {
        context.response()
                .putHeader("content-type", "application/json")
                .end("{ \"characters\": []}");
    }
}
