package com.tim.marvel.api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.vertx.core.Vertx;

public class MarvelApp {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MarvelModule());
        MarvelVerticle verticle = injector.getInstance(MarvelVerticle.class);
        Vertx vertx = injector.getInstance(Vertx.class);

        vertx.deployVerticle(verticle);
    }
}
