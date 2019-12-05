package com.ehabibov.context.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class AppEventOnRefresh implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("REFRESHED CONTEXT");
        System.out.println("SOURCE" + event.getSource().toString());
        for (String bean : event.getApplicationContext().getBeanDefinitionNames()){
            System.out.println(bean);
        }

    }
}
