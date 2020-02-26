package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrganizationInfoResponseBinding implements Serializable {
    private static final long serialVersionUID = 4150001972601804098L;

    private int id;
    private String name;
    private String taxId;
    @JsonProperty("registraionNumber")
    private String registrationNumber;
    private String phone;
    private String fax;
    private String email;
    private String country;
    private String province;
    private String city;
    private String zipCode;
    private String street1;
    private String street2;
    private String note;
    private int numberOfEmployees;

    @Override
    public String toString() {
        return String.format("OrganizationInfoResponseBinding{id=%s, name=%s, taxId=%s, registrationNumber=%s," +
                        "phone=%s, fax=%s, email=%s, country=%s, province=%s, city=%s, zipCode=%s, street1=%s," +
                        "street2=%s, note=%s, numberOfEmployees=%s}",
                id, name, taxId, registrationNumber, phone, fax, email, country, province,
                city, zipCode, street1, street2, note, numberOfEmployees);
    }
}