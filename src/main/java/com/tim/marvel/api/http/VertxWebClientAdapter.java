package com.tim.marvel.api.http;

import com.google.inject.Inject;
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

public class VertxWebClientAdapter implements WebClientAdapter {

    private final Vertx vertx;

    @Inject
    public VertxWebClientAdapter(Vertx vertx) {
        this.vertx = vertx;
    }

    public WebClient getWebClient(WebClientOptions options) {
        return WebClient.create(vertx, options);
    }
}
