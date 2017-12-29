package com.tim.marvel.api;

import com.google.inject.Inject;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MarvelVerticle extends AbstractVerticle {

    @Inject
    private MarvelRouter router;

    @Override
    public void start() throws Exception {
        Router appRouter = router.buildRouter();
        vertx.createHttpServer().requestHandler(appRouter::accept).listen(8080);
        System.out.println("HTTP server started on port 8080");
    }
}
