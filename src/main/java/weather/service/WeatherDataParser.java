package weather.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import weather.model.CurrentObservation;

import java.io.IOException;

public class WeatherDataParser {

    private static final String CURRENT_OBSERVATION = "current_observation";

    public CurrentObservation parseDataToCurrentObservation(String jsonData) {
        JsonParser parser = new JsonParser();
        JsonObject element = (JsonObject) parser.parse(jsonData);
        JsonElement node  = element.get(CURRENT_OBSERVATION);
        return new Gson().fromJson(node, CurrentObservation.class);
    }

}
