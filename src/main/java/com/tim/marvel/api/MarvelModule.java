package com.tim.marvel.api;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.tim.marvel.api.character.*;
import io.vertx.core.Vertx;

public class MarvelModule extends AbstractModule {
    @Provides
    @Singleton
    public Vertx getVertx() {
        return Vertx.vertx();
    }

    @Override
    protected void configure() {
        configureApp();
        configureHandlers();
        configureServices();
        configureRepositories();
    }

    private void configureApp() {
        bind(MarvelVerticle.class).asEagerSingleton();
        bind(MarvelRouter.class).asEagerSingleton();
    }

    private void configureHandlers() {
        bind(CharacterHandler.class).asEagerSingleton();
    }

    private void configureServices() {
        bind(CharacterService.class).to(MarvelCharacterService.class).asEagerSingleton();
    }

    private void configureRepositories() {
        bind(CharacterRepository.class).to(MarvelApiCharacterRepository.class).asEagerSingleton();
    }
}
