package com.tim.marvel.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tim.marvel.api.handlers.GetCharacterHandler;
import com.tim.marvel.api.handlers.GetCharacterListHandler;
import io.vertx.core.Vertx;

public class MarvelModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MarvelVerticle.class).asEagerSingleton();
        bind(MarvelRouter.class).asEagerSingleton();
        bind(GetCharacterHandler.class).asEagerSingleton();
        bind(GetCharacterListHandler.class).asEagerSingleton();
    }

    @Provides
    @Singleton
    public Vertx getVertx() {
        return Vertx.vertx();
    }
}