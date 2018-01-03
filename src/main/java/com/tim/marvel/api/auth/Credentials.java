package com.tim.marvel.api.auth;

import lombok.Getter;

public class Credentials {

    @Getter
    private String publicKey;

    @Getter
    private String hash;

    @Getter
    private String timeStamp;

    public Credentials(String publicKey, String hash, String timeStamp) {
        this.publicKey = publicKey;
        this.hash = hash;
        this.timeStamp = timeStamp;
    }
}
