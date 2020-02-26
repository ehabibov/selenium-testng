package com.ehabibov.driver.config.browser;

import org.openqa.selenium.chrome.ChromeOptions;;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;

import java.util.stream.Collectors;
import java.util.List;
import java.io.File;

import com.ehabibov.driver.config.OptionsHolder;

public class ChromeOptionsHolder implements OptionsHolder {

    private ChromeOptions options = new ChromeOptions();

    @Override
    public ChromeOptions getOptions() {
        return this.options;
    }

    public void setExtensions(final List<String> extensionPaths) {
        if (extensionPaths != null) {
            List<File> extensionFiles = extensionPaths.stream()
                    .filter(path -> !path.isEmpty())
                    .map(File::new)
                    .collect(Collectors.toList());
            options.addExtensions(extensionFiles);
        }
    }

    public void setAcceptInsecureCerts(final boolean isAcceptInsecureCerts) {
        options.setAcceptInsecureCerts(isAcceptInsecureCerts);
    }

    public void setCapabilities(final List<String> capabilities) {
        if (capabilities != null) {
            capabilities.stream()
                    .filter(cap -> !cap.isEmpty())
                    .map(string -> string.trim().split("::", 2))
                    .forEach(array -> options.setCapability(array[0], array[1]));
        }
    }

    public void setHeadless(final boolean isHeadless) {
        options.setHeadless(isHeadless);
    }

    public void setStrictFileInteractability(final boolean isStrictFileInteractability) {
        options.setStrictFileInteractability(isStrictFileInteractability);
    }

    public void setPageLoadStrategy(final String strategy) {
        options.setPageLoadStrategy(PageLoadStrategy.valueOf(strategy.toUpperCase()));
    }

    public void setUnhandledPromptBehaviour(final String unhandledPromptBehaviour) {
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.valueOf(unhandledPromptBehaviour.toUpperCase()));
    }

    public void setArguments(final List<String> arguments) {
        if (arguments != null) {
            List<String> filteredArguments = arguments.stream()
                    .filter(path -> !path.isEmpty()).collect(Collectors.toList());
            options.addArguments(filteredArguments);
        }
    }

    public void setProxy(final Proxy proxy) {
        options.setProxy(proxy);
    }
}