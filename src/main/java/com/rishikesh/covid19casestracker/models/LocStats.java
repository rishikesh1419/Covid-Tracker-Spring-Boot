package com.rishikesh.covid19casestracker.models;

public class LocStats {

    private String province;
    private String country;
    private int totalCases;
    private int oneDayDiff;

    public LocStats() {

    }

    public LocStats(String province, String country, int totalCases, int oneDayDiff) {
        this.province = province;
        this.country = country;
        this.totalCases = totalCases;
        this.oneDayDiff = oneDayDiff;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getOneDayDiff() {
        return oneDayDiff;
    }

    public void setOneDayDiff(int oneDayDiff) {
        this.oneDayDiff = oneDayDiff;
    }

    @Override
    public String toString() {
        return "LocStats{" +
                "province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", totalCases=" + totalCases +
                ", oneDayDiff=" + oneDayDiff +
                '}';
    }
}
