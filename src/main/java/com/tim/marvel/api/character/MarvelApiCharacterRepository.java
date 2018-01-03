package com.tim.marvel.api.character;

import com.google.inject.Inject;
import com.tim.marvel.api.auth.Credentials;
import com.tim.marvel.api.http.WebClientAdapter;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.ext.web.codec.BodyCodec;

public class MarvelApiCharacterRepository implements CharacterRepository {

    private final WebClient webClient;

    @Inject
    public MarvelApiCharacterRepository(WebClientAdapter webClientAdapter) {
        WebClientOptions options = new WebClientOptions();
        options.setKeepAlive(false);
        options.setFollowRedirects(false);
        options.setConnectTimeout(3000);
        options.setDefaultHost("gateway.marvel.com");
        options.setDefaultPort(443);

        this.webClient = webClientAdapter.getWebClient(options);
    }

    public void getCharacter(int id, Credentials credentials, Handler<CharacterResult> callback) {
        String uri = String.format(
                "/v1/public/characters/%s?ts=%s&apiKey=%s&hash=%s",
                id,
                credentials.getTimeStamp(),
                credentials.getPublicKey(),
                credentials.getHash());

            webClient
                .get(uri)
                .timeout(2000)
                .as(BodyCodec.jsonObject())
                .send(ar -> {
                    if (ar.succeeded()) {
                        JsonObject characterJson = null;

                        HttpResponse<JsonObject> response = ar.result();
                        int statusCode = response.statusCode();

                        if(statusCode == 200) {
                            characterJson = response.body();
                        }

                        callback.handle(new CharacterResult(statusCode, characterJson, null));
                    }
                    else {
                        Exception error = new Exception(ar.cause());

                        callback.handle(new CharacterResult(0, null, error));
                    }
                });
    }
}
