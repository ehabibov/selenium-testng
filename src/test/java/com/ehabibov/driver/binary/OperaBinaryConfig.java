package com.ehabibov.driver.binary;

import io.github.bonigarcia.wdm.Architecture;
import io.github.bonigarcia.wdm.OperatingSystem;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class OperaBinaryConfig {

    private WebDriverManager manager;

    private String driverBinaryFolder;
    private String desiredDriverPlatform;
    private String desiredDriverVersion;
    private String desiredBinaryArchitecture;
    private String targetBrowserPath;
    private String binaryDownloadTimeout;
    private String driverVersionAsJavaPreferenceTtl;
    private String binariesRepositoryUrl;
    private String gitHubTokenName;
    private String getGitHubTokenSecret;
    private String proxySocket;
    private String proxyUser;
    private String proxyPass;

    public OperaBinaryConfig(String driverBinaryFolder, String desiredDriverPlatform,
                             String desiredDriverVersion, String desiredBinaryArchitecture,
                             String targetBrowserPath, String binaryDownloadTimeout,
                             String driverVersionAsJavaPreferenceTtl, String binariesRepositoryUrl,
                             String gitHubTokenName, String getGitHubTokenSecret,
                             String proxySocket, String proxyUser, String proxyPass) {
        this.driverBinaryFolder = driverBinaryFolder;
        this.desiredDriverPlatform = desiredDriverPlatform;
        this.desiredDriverVersion = desiredDriverVersion;
        this.desiredBinaryArchitecture = desiredBinaryArchitecture;
        this.targetBrowserPath = targetBrowserPath;
        this.binaryDownloadTimeout = binaryDownloadTimeout;
        this.driverVersionAsJavaPreferenceTtl = driverVersionAsJavaPreferenceTtl;
        this.binariesRepositoryUrl = binariesRepositoryUrl;
        this.gitHubTokenName = gitHubTokenName;
        this.getGitHubTokenSecret = getGitHubTokenSecret;
        this.proxySocket = proxySocket;
        this.proxyUser = proxyUser;
        this.proxyPass = proxyPass;
    }

    public void construct() {
        manager = WebDriverManager.operadriver()
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
    }

    public void init(){
        manager.setup();
    }

    public String getBinaryPath(){
        return manager.getBinaryPath();
    }

    public String getDownloadedVersion(){
        return manager.getDownloadedVersion();
    }

    public List<String> getAvailableVersions(){
        return manager.getVersions();
    }

    public URL urlExceptionHandler(String url){
        try {
            return new URL(url);
        } catch (MalformedURLException ex){
            System.out.println("URL is incorrect: " + url);
            return null;
        }

    }
}
