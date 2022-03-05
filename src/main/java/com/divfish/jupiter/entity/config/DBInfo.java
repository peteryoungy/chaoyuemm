package com.divfish.jupiter.entity.config;

public class DBInfo {

    public String rdsEndpoint;
    public String username;
    public String password;

    public DBInfo() {

    }

    public DBInfo(String rdsEndpoint, String username, String password) {
        this.rdsEndpoint = rdsEndpoint;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "DBInfo{" +
                "rdsEndpoint='" + rdsEndpoint + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getRds_endpoint() {
        return rdsEndpoint;
    }

    public void setRds_endpoint(String rdsEndpoint) {
        this.rdsEndpoint = rdsEndpoint;
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
}
