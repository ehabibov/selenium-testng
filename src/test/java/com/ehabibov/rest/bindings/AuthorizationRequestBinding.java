package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorizationRequestBinding implements Serializable {
    private static final long serialVersionUID = -6768402490387094932L;

    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("grant_type")
    private String grantType;

}