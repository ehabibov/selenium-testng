package com.ehabibov.context;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public abstract class ApplicationContextSingleton {

    private static AbstractApplicationContext appContext;

    public static AbstractApplicationContext getContext(){
        if (appContext == null){
            appContext = new GenericXmlApplicationContext("application-context.xml");
        }
        return appContext;
    }
}
