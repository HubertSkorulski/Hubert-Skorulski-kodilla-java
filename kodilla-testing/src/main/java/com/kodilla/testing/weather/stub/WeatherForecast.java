package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
    public Map<String,Double> calculateForecast(){

        Map<String,Double> resultMap = new HashMap<>();

        for (Map.Entry<String,Double> temperature:temperatures.getTemperatures().entrySet()){
            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
    public double averageTemp() {
        double avgTemp = 0;
        for (Map.Entry<String,Double> temperature:temperatures.getTemperatures().entrySet()){
            avgTemp = avgTemp + temperature.getValue();
        }
        avgTemp = avgTemp/temperatures.getTemperatures().size();
        return avgTemp;
    }

    public double medianTemp() {
        List<Double> sortTemp = new ArrayList<>();
        double median = 0;
        for (Map.Entry<String,Double> temperature:temperatures.getTemperatures().entrySet()){
            sortTemp.add(temperature.getValue());
        }
        Collections.sort(sortTemp);
        if (sortTemp.size()%2!=0) {
            median = sortTemp.get(Math.round(sortTemp.size()/2));
        } else {
            median = (sortTemp.get(sortTemp.size()-1)/2) + sortTemp.get(sortTemp.size()/2)/2;
        }
        return median;


    }
}
