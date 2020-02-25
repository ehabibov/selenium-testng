package com.ehabibov.tests;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.*;

public class CustomAsserts {

    //TODO: use something specific, not object references
    @Step("Assert objects \"{actual}\" \"{expected}\" equal ignoring fields {fieldNames}")
    public static void assertObjectsEqualIgnoringFields(final Object actual, final Object expected, String...fieldNames){
        assertThat(actual).isEqualToIgnoringGivenFields(expected, fieldNames);
        new Object();
    }

}