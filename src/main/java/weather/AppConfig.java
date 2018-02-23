package weather;

import weather.service.WeatherService;

public class AppConfig {

    public static WeatherApi weatherApi(){
        return new WeatherApi(weatherService());
    }

    public static WeatherService weatherService(){
        return new WeatherService();
    }

}
