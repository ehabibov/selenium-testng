package com.ehabibov.context.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

public class AppEventOnStartup implements ApplicationListener<ContextStartedEvent> {

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("STARTED CONTEXT");
        System.out.println("SOURCE" + event.getSource().toString());
        for (String bean : event.getApplicationContext().getBeanDefinitionNames()){
            System.out.println(bean);
        }

    }
}
