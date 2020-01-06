package com.ehabibov.context.listeners;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.ApplicationListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AppEventOnStartup implements ApplicationListener<ContextStartedEvent> {

    private static final Logger log = LoggerFactory.getLogger(AppEventOnStartup.class);

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        log.debug("EVENT: CONTEXT STARTED");
        log.debug("Source: " + event.getSource().toString());
        log.debug("Beans definitions:");
        for (String bean : event.getApplicationContext().getBeanDefinitionNames()){
            log.debug("- " + bean);
        }
    }
}
