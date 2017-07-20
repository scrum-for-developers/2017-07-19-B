package de.codecentric.psd.worblehat.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class StartupMonitor {

    private Environment env;

    private static final String[] PROPERTIES =
            { "spring.datasource.url",
                    "spring.datasource.username",
                    "spring.datasource.password",
                    "spring.datasource.driver-class-name",
                    "server.context-path",
                    "info.version",
                    "info.stage",
                    "logging.file",
                    "liquibase.change-log",
                    "spring.jpa.hibernate.ddl-auto",
                    "server.port" };
    
    public static Map<String,String> PROPERTIES_MAP;

    private static final Logger LOG = LoggerFactory
            .getLogger(StartupMonitor.class);

    @Autowired
    public StartupMonitor(Environment env) {
        this.env = env;
    }

    @EventListener
    public void onStartUp(ApplicationReadyEvent applicationReadyEvent) {
        LOG.info("Used profiles:");
        
        PROPERTIES_MAP = new HashMap<>();
        
        for (String property : PROPERTIES) {
            String propInfo = property + " " + env.getProperty(property);
            LOG.info(propInfo);
            PROPERTIES_MAP.put(property, env.getProperty(property));
        }
    }
}


