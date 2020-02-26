package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrganizationInfoResponseBindingWrapper implements Serializable {
    private static final long serialVersionUID = 3400255817205547169L;

    @JsonProperty("data")
    private OrganizationInfoResponseBinding organizationInfo;
    private List<String> rels;

    @Override
    public String toString() {
        return String.format("OrganizationInfoResponseBindingWrapper{organizationInfo=%s, rels=%s}",
                organizationInfo, rels);
    }
}