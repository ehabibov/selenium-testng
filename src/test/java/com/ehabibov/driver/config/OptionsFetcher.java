package com.ehabibov.driver.config;

import com.ehabibov.context.ApplicationContextSingleton;
import org.openqa.selenium.Capabilities;

public class OptionsFetcher {

    private OptionsHolder optionsHolder;

    public <T extends OptionsHolder> OptionsFetcher(Class<T> clazz) {
        this.optionsHolder = ApplicationContextSingleton.getContext().getBean(clazz);
    }

    public Capabilities getOptions() {
        return optionsHolder.getOptions();
    }

}