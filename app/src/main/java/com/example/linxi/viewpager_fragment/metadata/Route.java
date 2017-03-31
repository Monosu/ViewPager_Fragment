package com.example.linxi.viewpager_fragment.metadata;

/**
 * Created by linxi on 2017/3/28.
 */

public class Route {
    private String city;
    private float distance;
    private int level;
    private int routeId;
    private String routrName;
    private int routeSerialNumber;
    private int totalDownloads;
    private String gpxFileUrl;
    private String gpxCompressFile;
    private String gpxPicUrl;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public String getRoutrName() {
        return routrName;
    }

    public void setRoutrName(String routrName) {
        this.routrName = routrName;
    }

    public int getRouteSerialNumber() {
        return routeSerialNumber;
    }

    public void setRouteSerialNumber(int routeSerialNumber) {
        this.routeSerialNumber = routeSerialNumber;
    }

    public int getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(int totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    public String getGpxFileUrl() {
        return gpxFileUrl;
    }

    public void setGpxFileUrl(String gpxFileUrl) {
        this.gpxFileUrl = gpxFileUrl;
    }

    public String getGpxCompressFile() {
        return gpxCompressFile;
    }

    public void setGpxCompressFile(String gpxCompressFile) {
        this.gpxCompressFile = gpxCompressFile;
    }

    public String getGpxPicUrl() {
        return gpxPicUrl;
    }

    public void setGpxPicUrl(String gpxPicUrl) {
        this.gpxPicUrl = gpxPicUrl;
    }
}
