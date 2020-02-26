package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorizationResponseBinding implements Serializable {
    private static final long serialVersionUID = 7442022484028315617L;

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiration;
    @JsonProperty("token_type")
    private String tokenType;
    private String scope;

}