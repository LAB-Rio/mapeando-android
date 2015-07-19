package labrio.mapeando;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

import labrio.mapeando.adapters.MapeandoService;
import labrio.mapeando.adapters.RestClient;
import labrio.mapeando.models.Demand;
import labrio.mapeando.models.Pin;
import labrio.mapeando.resources.PicassoMarker;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MapViewFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "1";

    // We use this to check changes on location @ startup
    private static boolean isInitialMapSet = false;

    // Setting up MapView
    MapView mapView;
    GoogleMap map;


    // Empty constructor
    public MapViewFragment(){};


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);

        // Get XML of the map and create it
        mapView = (MapView) view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);


        // Setup google maps
        map = mapView.getMap();
        map.getUiSettings().setMyLocationButtonEnabled(false);
        map.setMyLocationEnabled(true);

        // Needs to call MapsInitializer before doing any CameraUpdateFactory calls
        MapsInitializer.initialize(this.getActivity());

        map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {

            @Override
            public void onMyLocationChange(Location arg0) {
                setInitialCamera(new LatLng(arg0.getLatitude(), arg0.getLongitude()));
            }
        });


        setInitialMarkers();

        return view;

    }

    /***
     * Set initial camera when the user opens the app.
     * @param myLocation
     */
    private void setInitialCamera(LatLng myLocation) {


        // TODO Auto-generated method stub
        //map.addMarker(new MarkerOptions().position(new LatLng(arg0.getLatitude(),
        //      arg0.getLongitude())).title("It's Me!"));
        if (!isInitialMapSet) {
            // Updates the location and zoom of the MapView
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(myLocation, 13);
            map.animateCamera(cameraUpdate);
            isInitialMapSet = true;
        }
    }

    // Load initial markers
    private void setInitialMarkers(){
        RestClient client = new RestClient();

        MapeandoService service = client.getService();

        service.demandList(new Callback<Demand>() {
            @Override
            public void success(Demand demandList, Response response) {
                loadDemands(demandList);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Retrofit TagError", String.valueOf(error));
            }
        });
    }


    /**
     * Load demands on map
     * @param demandList
     */
    public void loadDemands(Demand demandList){
        for (Demand demand : demandList.demands) {

            if (demand == null || demand.getPins() == null)
                break;

            for (Pin pin : demand.getPins()) {

                // Set the current category ICON
                String url = demand.getCategory().getIconUrl();


                Marker myMarker = map.addMarker(new MarkerOptions()
                        .position(new LatLng(pin.getLat(), pin.getLong()))
                        .title(demand.getFullname()));

                PicassoMarker marker = new PicassoMarker(myMarker);
                Picasso.with(getActivity()).load(url).into(marker);
            }

            Log.d("Retrofit DemandSize", String.valueOf(demandList.demands.size()));


        }

    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

}
