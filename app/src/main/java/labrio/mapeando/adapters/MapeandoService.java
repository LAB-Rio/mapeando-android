package labrio.mapeando.adapters;


import java.util.List;

import labrio.mapeando.models.Demand;
import retrofit.Callback;
import retrofit.http.GET;

public interface MapeandoService {

    @GET("/demands.json")
    public void demandList(Callback<Demand> response);

}