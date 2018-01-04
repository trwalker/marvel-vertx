package com.tim.marvel.api.config;

import io.vertx.core.Handler;

public interface ConfigService {
    Environment getEnvironment();

    void getConfig(Handler<Config> callback);
}
