package com.divfish.jupiter.entity.config;


import org.springframework.stereotype.Component;

@Component
public class YamlConfig {

    public DBInfo dbInfo;
    public TwitchToken twitchToken;

    public YamlConfig() {
    }

    // note: outer class must have this single argument constructor in order to serialize yaml to object
    public YamlConfig(DBInfo dbInfo, TwitchToken twitchToken) {
        this.dbInfo = dbInfo;
        this.twitchToken = twitchToken;
    }

//    public YamlConfig(DBInfo dbInfo) {
//        this.dbInfo = dbInfo;
//    }
//
//    public YamlConfig(TwitchToken twitchToken) {
//        this.twitchToken = twitchToken;
//    }

    @Override
    public String toString() {
        return "YamlConfig{" +
                "dbInfo=" + dbInfo +
                ", twitchToken=" + twitchToken +
                '}';
    }

    public DBInfo getDbInfo() {
        return dbInfo;
    }

    public void setDbInfo(DBInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    public TwitchToken getTwitchToken() {
        return twitchToken;
    }

    public void setTwitchToken(TwitchToken twitchToken) {
        this.twitchToken = twitchToken;
    }
}
