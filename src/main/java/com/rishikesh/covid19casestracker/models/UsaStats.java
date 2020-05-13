package com.rishikesh.covid19casestracker.models;

public class UsaStats {
    private String county;
    private String state;
    private int totalCountyCases;
    private int oneDayCountyDiff;
    
    public UsaStats() {
        
    }

    public UsaStats(String county, String state, int totalCountyCases, int oneDayCountyDiff) {
        this.county = county;
        this.state = state;
        this.totalCountyCases = totalCountyCases;
        this.oneDayCountyDiff = oneDayCountyDiff;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTotalCountyCases() {
        return totalCountyCases;
    }

    public void setTotalCountyCases(int totalCountyCases) {
        this.totalCountyCases = totalCountyCases;
    }

    public int getOneDayCountyDiff() {
        return oneDayCountyDiff;
    }

    public void setOneDayCountyDiff(int oneDayCountyDiff) {
        this.oneDayCountyDiff = oneDayCountyDiff;
    }

    @Override
    public String toString() {
        return "UsaStats{" +
                "county='" + county + '\'' +
                ", state='" + state + '\'' +
                ", totalCountyCases=" + totalCountyCases +
                ", oneDayCountyDiff=" + oneDayCountyDiff +
                '}';
    }
}
