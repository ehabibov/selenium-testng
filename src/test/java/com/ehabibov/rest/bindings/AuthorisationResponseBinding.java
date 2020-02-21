package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class AuthorisationResponseBinding implements Serializable {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiration;
    @JsonProperty("token_type")
    private String tokenType;
    private String scope;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}