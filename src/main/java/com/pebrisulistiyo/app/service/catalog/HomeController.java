package com.pebrisulistiyo.app.service.catalog;

import com.pebrisulistiyo.app.service.catalog.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final AppProperties appProperties;

    public HomeController(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @GetMapping
    public String getGreeting() {
        return appProperties.getGreeting();
    }
}
