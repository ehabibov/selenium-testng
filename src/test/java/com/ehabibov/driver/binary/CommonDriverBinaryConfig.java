package com.ehabibov.driver.binary;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Setter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CommonDriverBinaryConfig implements DriverBinaryConfig {

    private WebDriverManager manager;

    @Setter private String browserType;
    @Setter private String driverBinaryFolder;
    @Setter private String desiredDriverPlatform;
    @Setter private String desiredDriverVersion;
    @Setter private String desiredBinaryArchitecture;
    @Setter private String targetBrowserPath;
    @Setter private String binaryDownloadTimeout;
    @Setter private String driverVersionAsJavaPreferenceTtl;
    @Setter private String binariesRepositoryUrl;
    @Setter private String gitHubTokenName;
    @Setter private String getGitHubTokenSecret;
    @Setter private String proxySocket;
    @Setter private String proxyUser;
    @Setter private String proxyPass;

    @Override
    public void init() {
        manager = WebDriverManager.getInstance(DriverManagerType.valueOf(browserType.toUpperCase()))
                .targetPath(driverBinaryFolder)
                .operatingSystem(OperatingSystem.valueOf(desiredDriverPlatform))
                .version(desiredDriverVersion)
                .architecture(Architecture.valueOf(desiredBinaryArchitecture))
                .browserPath(targetBrowserPath)
                .timeout(Integer.parseInt(binaryDownloadTimeout))
                .ttl(Integer.parseInt(driverVersionAsJavaPreferenceTtl))
                .driverRepositoryUrl(urlExceptionHandler(binariesRepositoryUrl))
                .gitHubTokenName(gitHubTokenName)
                .gitHubTokenSecret(getGitHubTokenSecret)
                .proxy(proxySocket)
                .proxyUser(proxyUser)
                .proxyPass(proxyPass);
        manager.setup();
    }

    @Override
    public String getBinaryPath() {
        return manager.getBinaryPath();
    }

    public String getDownloadedVersion() {
        return manager.getDownloadedVersion();
    }

    public List<String> getAvailableVersions() {
        return manager.getVersions();
    }

    public URL urlExceptionHandler(final String url) {
        try {
            return new URL(url);
        } catch (final MalformedURLException ex) {
            System.out.println("URL is incorrect: " + url);
            return null;
        }
    }
}