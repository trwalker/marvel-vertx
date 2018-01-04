package com.tim.marvel.api.config;

import com.google.inject.Inject;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class MarvelConfigService implements ConfigService {

    private static final String ENV_KEY = "ENV";
    private static final String BASE_CONFIG_FILE_PATH = "src/main/resources/config";

    private final Vertx vertx;

    private Environment environment;
    private Config config;

    @Inject
    public MarvelConfigService(Vertx vertx) {
        this.vertx = vertx;
    }

    public Environment getEnvironment() {
        if(environment == null) {
            String env = System.getenv(ENV_KEY);

            try {
                environment = Environment.valueOf(env);
            }
            catch(Exception ex) {
                environment = Environment.prod;
            }
        }

        return environment;
    }

    public void getConfig(Handler<Config> callback) {
        if(config != null) {
            callback.handle(config);
        }
        else {
            ConfigRetriever retriever = getConfigRetriever();

            retriever.getConfig(ar -> {
                if(ar.succeeded()) {
                    JsonObject jsonConfig = ar.result();
                    System.out.println(String.format("foo: %s", jsonConfig.getString("foo")));
                    System.out.println(String.format("port: %s", jsonConfig.getInteger("port")));

                    config = new Config();
                    callback.handle(config);
                }
            });
        }
    }

    private ConfigRetriever getConfigRetriever() {
        ConfigStoreOptions baseConfig = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", String.format("%s/config.json", BASE_CONFIG_FILE_PATH)));

        ConfigStoreOptions envConfig = new ConfigStoreOptions()
                .setType("file")
                .setConfig(new JsonObject().put("path", String.format("%s/config.%s.json", BASE_CONFIG_FILE_PATH, getEnvironment())));


        ConfigRetrieverOptions options = new ConfigRetrieverOptions().addStore(baseConfig).addStore(envConfig);

        return ConfigRetriever.create(vertx, options);
    }
}