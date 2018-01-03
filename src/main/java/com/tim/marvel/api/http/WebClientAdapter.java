package com.tim.marvel.api.http;

import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;

public interface WebClientAdapter {
    WebClient getWebClient(WebClientOptions options);
}
