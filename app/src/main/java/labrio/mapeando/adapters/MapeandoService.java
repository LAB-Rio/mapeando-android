package labrio.mapeando.adapters;

import java.util.List;

import labrio.mapeando.models.Demand;
import retrofit.http.GET;

public interface MapeandoService {

    @GET("/demands")
    List<Demand> demandsList();

}