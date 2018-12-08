package com.hnj.locationservice.entities;

public class IpLocation {
    private String ip;
    private String country;
    private String region;
    private String city;

    public IpLocation(){}

    public IpLocation(String ip, String country, String region, String city) {
        this.ip = ip;
        this.country = country;
        this.region = region;
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
