package labrio.mapeando.resources;
import com.google.android.gms.maps.model.LatLng;

public class MarkerClusterItem implements ClusterItem {



    @Override
    public LatLng getPosition(){
        return mPosition;
    }
}


