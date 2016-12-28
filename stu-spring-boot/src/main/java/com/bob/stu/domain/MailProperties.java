package com.bob.stu.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;


/**
 * TODO 一句话描述功能
 *
 * @author bob
 * @since 2016-11-13 23:13
 */
@Configuration
@ConfigurationProperties(value = "classpath:mail.properties", ignoreUnknownFields = false, prefix = "mail")
public class MailProperties {
    public static class Smtp {
        private boolean auth;
        private boolean starttlsEnable;
        // ... getters and setters
    }

    @NotBlank
    private String host;
    private int port;
    private String from;
    private String username;
    private String password;
    @NotNull
    private Smtp smtp;
    // ... getters and setters


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Smtp getSmtp() {
        return smtp;
    }

    public void setSmtp(Smtp smtp) {
        this.smtp = smtp;
    }
}
