package com.ehabibov.listeners;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.testng.ISuiteListener;
import org.testng.ISuite;

public class SeleniumSuiteListener implements ISuiteListener {

    private static final Logger log = LoggerFactory.getLogger(SeleniumSuiteListener.class);

    @Override
    public void onStart(ISuite context) {
        log.info("suite onStart");
    }

    @Override
    public void onFinish(ISuite context) {
        log.info("suite onFinish");
    }

}
