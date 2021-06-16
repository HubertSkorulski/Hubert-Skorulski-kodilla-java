package com.kodilla.testing.weather.mock;
import com.kodilla.testing.weather.stub.Temperatures;                         // [2]
import com.kodilla.testing.weather.stub.WeatherForecast;                      // [3]
import org.junit.jupiter.api.Assertions;                                      // [4]
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void theCalculateForecastWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }
    @Test
    void theAverageTemperatureWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 20.0);
        temperaturesMap.put("Krakow", 20.0);
        temperaturesMap.put("Wroclaw", 20.0);
        temperaturesMap.put("Warszawa", 25.0);
        temperaturesMap.put("Gdansk", 25.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double average = weatherForecast.averageTemp();
        //Then
        Assertions.assertEquals(22.0, average);
    }
    @Test
    void theMedianTemperatureWithMock() {
        //Given
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 18.0);
        temperaturesMap.put("Krakow", 19.0);
        temperaturesMap.put("Wroclaw", 20.0);
        temperaturesMap.put("Warszawa", 21.0);
        temperaturesMap.put("Gdansk", 22.0);
        //temperaturesMap.put("Gdynia", 23.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double median = weatherForecast.medianTemp();
        //Then
        Assertions.assertEquals(20.0, median);
    }
}
