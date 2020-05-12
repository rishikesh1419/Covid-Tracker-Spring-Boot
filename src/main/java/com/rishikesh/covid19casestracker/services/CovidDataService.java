package com.rishikesh.covid19casestracker.services;

import com.rishikesh.covid19casestracker.models.LocStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.env.SystemEnvironmentPropertySourceEnvironmentPostProcessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.SocketOption;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataService {

    public static String COVID_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocStats> allStats = new ArrayList<>();

    public List<LocStats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "0 0 1 * * *")
    public void getCovidData() throws IOException, InterruptedException {
        List<LocStats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(COVID_DATA_URL)).build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());

        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocStats locStat = new LocStats();
            locStat.setCountry(record.get("Country/Region"));
            locStat.setProvince(record.get("Province/State"));
            int today = Integer.parseInt(record.get(record.size() - 1));
            int yesterday =  Integer.parseInt(record.get(record.size() - 2));
            locStat.setTotalCases(today);
            locStat.setOneDayDiff(today - yesterday);
            newStats.add(locStat);
        }
        this.allStats = newStats;
    }
}
