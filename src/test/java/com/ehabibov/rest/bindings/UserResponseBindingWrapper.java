package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class UserResponseBindingWrapper implements Serializable {

    @JsonProperty("data")
    private List<UserResponseBinding> users;
    private List<String> rels;

    public List<UserResponseBinding> getUsers() {
        return users;
    }

    public void setUsers(List<UserResponseBinding> users) {
        this.users = users;
    }

    public List<String> getRels() {
        return rels;
    }

    public void setRels(List<String> rels) {
        this.rels = rels;
    }

    @Override
    public String toString() {
        return String.format("UserResponseBindingWrapper{users=%s, rels=%s", users, rels);
    }
}