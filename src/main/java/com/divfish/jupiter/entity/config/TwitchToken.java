package com.divfish.jupiter.entity.config;

public class TwitchToken {

    public String token;
    public String clientId;

    @Override
    public String toString() {
        return "TwitchToken{" +
                "token='" + token + '\'' +
                ", clientId='" + clientId + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
