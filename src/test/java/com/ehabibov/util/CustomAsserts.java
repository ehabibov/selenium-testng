package com.ehabibov.util;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.*;

public final class CustomAsserts {

    private CustomAsserts() { }

    //TODO: use something specific, not object references
    @Step("Assert objects \"{actual}\" \"{expected}\" equal ignoring fields {fieldNames}")
    public static void assertEqualIgnoringFields(
            final Object actual, final Object expected, final String...fieldNames) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected, fieldNames);
    }

}