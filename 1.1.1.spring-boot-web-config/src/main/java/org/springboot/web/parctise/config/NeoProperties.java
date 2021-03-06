package org.springboot.web.parctise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class NeoProperties {

    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NeoProperties{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
