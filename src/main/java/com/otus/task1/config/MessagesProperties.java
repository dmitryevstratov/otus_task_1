package com.otus.task1.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "service.params.messages")
public class MessagesProperties {

    private String firstName;

    private String secondName;

    private String emptyFile;

    private String charset;

}
