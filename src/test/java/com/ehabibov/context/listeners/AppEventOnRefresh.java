package com.ehabibov.context.listeners;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class AppEventOnRefresh implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = LoggerFactory.getLogger(AppEventOnRefresh.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("EVENT: CONTEXT REFRESHED");
        log.debug("Source: " + event.getSource().toString());
        log.debug("Beans definitions:");
        for (String bean : event.getApplicationContext().getBeanDefinitionNames()){
            log.debug("- " + bean);
        }
    }
}
