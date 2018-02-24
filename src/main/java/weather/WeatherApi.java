package weather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weather.model.CurrentObservation;
import weather.service.WeatherDataParser;
import weather.service.WeatherService;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApi {

    private final WeatherService weatherService;
    private final WeatherDataParser weatherDataParser;

    public WeatherApi(WeatherService weatherService, WeatherDataParser weatherDataParser){

        this.weatherService = weatherService;
        this.weatherDataParser = weatherDataParser;
    }




    public void getWeather(String zipCode) throws IOException {
        weatherService.fetchCurrentObservation(zipCode).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String weatherData = new String(response.body().bytes());
                    CurrentObservation output = weatherDataParser.parseDataToCurrentObservation(weatherData);
                    System.out.println(output.getDisplayLocation());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
