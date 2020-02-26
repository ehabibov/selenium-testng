package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserResponseBindingWrapper implements Serializable {
    private static final long serialVersionUID = 8104201398376093799L;

    @JsonProperty("data")
    private List<UserResponseBinding> users;
    private List<String> rels;

    @Override
    public String toString() {
        return String.format("UserResponseBindingWrapper{users=%s, rels=%s", users, rels);
    }
}