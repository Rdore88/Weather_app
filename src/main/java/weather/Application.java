package weather;

import java.io.IOException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("What zipcode would you like to look up?");
        Scanner zipcode_input = new Scanner(System.in);
        String zip_code = zipcode_input.nextLine();
        WeatherApi weatherApi = AppConfig.weatherApi();
        try {
            weatherApi.getWeather(zip_code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
