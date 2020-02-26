package com.ehabibov.rest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.List;

import com.ehabibov.rest.bindings.*;

public class GetUsers {

    private static String baseUri = "http://localhost:8080/symfony/web/index.php";

    public static void main(final String[] args) {
        RestAssured.defaultParser = Parser.JSON;
        String token = getToken();
        List<UserResponseBinding> users = getUsers(token);
        System.out.println(users.toString());
        OrganizationInfoResponseBinding organizationInfo = getOrganizationInfo(token);
        System.out.println(organizationInfo.toString());
    }

    private static String getToken() {
        String grantType = "client_credentials";
        String clientId = "testclient";
        String clientSecret = "testpass";

        String path = "/oauth/issueToken";

        AuthorizationRequestBinding requestBinding = new AuthorizationRequestBinding();
        requestBinding.setClientId(clientId);
        requestBinding.setClientSecret(clientSecret);
        requestBinding.setGrantType(grantType);

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(baseUri).setBasePath(path)
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBody(requestBinding).build();

        AuthorizationResponseBinding response = RestAssured.given(request)
                .when().post()
                .then().extract().response().as(AuthorizationResponseBinding.class, ObjectMapperType.JACKSON_2);

        String token = response.getAccessToken();
        System.out.println("Token:" + token);
        return token;
    }

    private static List<UserResponseBinding> getUsers(final String token) {
        String path = "/api/v1/user";

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(baseUri).setBasePath(path)
                .addHeader("Authorization", "Bearer " + token)
                .setAccept(ContentType.JSON).build();

        UserResponseBindingWrapper usersWrapper = RestAssured.given(request)
                .when().get()
                .then().extract().response().as(UserResponseBindingWrapper.class, ObjectMapperType.JACKSON_2);

        return usersWrapper.getUsers();
    }

    public static <T> List<T> jsonArrayToObjectList(final String json, final Class<T> tClass) {
        ObjectMapper mapper = new ObjectMapper();
        CollectionType listType = mapper.getTypeFactory().constructCollectionType(List.class, tClass);
        List<T> ts = null;
        try {
            ts = mapper.readValue(json, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ts;
    }

    public static OrganizationInfoResponseBinding getOrganizationInfo(final String token) {
        String path = "/api/v1/organization";

        RequestSpecification request = new RequestSpecBuilder().setBaseUri(baseUri).setBasePath(path)
                .addHeader("Authorization", "Bearer " + token)
                .setAccept(ContentType.JSON).build();

        OrganizationInfoResponseBindingWrapper organizationInfoResponseBindingWrapper = RestAssured.given(request)
                .when().get()
                .then().extract().response()
                .as(OrganizationInfoResponseBindingWrapper.class, ObjectMapperType.JACKSON_2);

        return organizationInfoResponseBindingWrapper.getOrganizationInfo();
    }
}