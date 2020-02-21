package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class OrganizationInfoResponseBindingWrapper implements Serializable {

    @JsonProperty("data")
    private OrganizationInfoResponseBinding organizationInfo;
    private List<String> rels;

    public OrganizationInfoResponseBinding getOrganizationInfo() {
        return organizationInfo;
    }

    public void setOrganizationInfo(OrganizationInfoResponseBinding organizationInfo) {
        this.organizationInfo = organizationInfo;
    }

    public List<String> getRels() {
        return rels;
    }

    public void setRels(List<String> rels) {
        this.rels = rels;
    }

    @Override
    public String toString() {
        return String.format("OrganizationInfoResponseBindingWrapper{organizationInfo=%s, rels=%s}", organizationInfo, rels);
    }
}
