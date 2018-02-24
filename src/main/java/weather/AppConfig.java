package weather;

import weather.service.WeatherDataParser;
import weather.service.WeatherService;

public class AppConfig {

    public static WeatherApi weatherApi(){
        return new WeatherApi(weatherService(), weatherDataParser());
    }

    public static WeatherService weatherService(){
        return new WeatherService();
    }

    public static WeatherDataParser weatherDataParser() {
        return new WeatherDataParser();
    }

}
