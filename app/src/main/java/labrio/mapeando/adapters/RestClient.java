package labrio.mapeando.adapters;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;


/**
 * Created by luizfonseca on 18/07/2015.
 */
public class RestClient {
    RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://lab-map.herokuapp.com")
            .build();

    MapeandoService service = restAdapter.create(MapeandoService.class);
}
