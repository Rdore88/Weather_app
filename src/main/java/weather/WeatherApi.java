package weather;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import weather.service.WeatherService;

import java.io.IOException;
import java.util.Scanner;

public class WeatherApi {

    private final WeatherService weatherService;

    public WeatherApi(WeatherService weatherService){
        this.weatherService = weatherService;
    }



    public void getWeather(String zipCode) throws IOException {
        weatherService.fetchCurrentObservation(zipCode).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String s = new String(response.body().bytes());
                    System.out.println(s);
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
