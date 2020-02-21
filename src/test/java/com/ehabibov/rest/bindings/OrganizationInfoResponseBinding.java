package com.ehabibov.rest.bindings;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class OrganizationInfoResponseBinding implements Serializable {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public String toString() {
        return String.format("OrganizationInfoResponseBinding{id=%s, name=%s, taxId=%s, registrationNumber=%s, phone=%s," +
                        "fax=%s, email=%s, country=%s, province=%s, city=%s, zipCode=%s, street1=%s, street2=%s, note=%s, numberOfEmployees=%s}",
                id, name, taxId, registrationNumber, phone, fax, email, country, province,
                city, zipCode, street1, street2, note, numberOfEmployees);

    }
}
