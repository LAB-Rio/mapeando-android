package labrio.mapeando.resources;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;


/**
 *  Implementation of Cluster Item from Gmaps API v2
 *
 */
public class MyClusterItem implements ClusterItem {
    private final LatLng mPosition;

    public MyClusterItem(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
    }

    @Override
    public LatLng getPosition(){
        return mPosition;
    }
}


