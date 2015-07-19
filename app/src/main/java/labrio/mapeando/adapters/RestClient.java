package labrio.mapeando.adapters;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;


public class RestClient {

    public RestAdapter buildRestAdapter(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint("http://lab-map.herokuapp.com")
                .build();


        return restAdapter;

    };

    public MapeandoService getService(){
        MapeandoService service = buildRestAdapter().create(MapeandoService.class);
        return service;
    }


}
