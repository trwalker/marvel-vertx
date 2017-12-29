package com.tim.marvel.api.handlers;

import io.vertx.ext.web.RoutingContext;

public class GetCharacterHandler {
    public void getCharacter(RoutingContext context) {
        context.response()
            .putHeader("content-type", "text/plain")
            .end("Hello from Vert.x!");
    }
}
