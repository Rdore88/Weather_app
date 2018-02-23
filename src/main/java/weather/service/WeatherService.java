package weather.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.GsonBuilder;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class WeatherService {

    private ServiceInterface serviceInterface;
    String serviceUrl = "http://api.wunderground.com/api/a0fad745509bd909/";

    public WeatherService(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        Gson gson = getGson();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().build();
        serviceInterface = new Retrofit.Builder()
                .baseUrl(serviceUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ServiceInterface.class);
    }

    private Gson getGson() {
        return new GsonBuilder()
                .create();
    }

    interface ServiceInterface {
        @GET("conditions/settings/q/{zipCode}.json")
        Call<ResponseBody> fetchCurrentObservation(@Path("zipCode") String zipCode);
    }

    public Call<ResponseBody> fetchCurrentObservation(String zipCode){
        return serviceInterface.fetchCurrentObservation(zipCode);
    }
}
