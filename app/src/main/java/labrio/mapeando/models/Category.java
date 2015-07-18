package labrio.mapeando.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("org.jsonschema2pojo")
public class Category {

    @Expose
    private String name;
    @SerializedName("travel_mode")
    @Expose
    private String travelMode;
    @SerializedName("marker_color")
    @Expose
    private String markerColor;
    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The travelMode
     */
    public String getTravelMode() {
        return travelMode;
    }

    /**
     *
     * @param travelMode
     * The travel_mode
     */
    public void setTravelMode(String travelMode) {
        this.travelMode = travelMode;
    }

    /**
     *
     * @return
     * The markerColor
     */
    public String getMarkerColor() {
        return markerColor;
    }

    /**
     *
     * @param markerColor
     * The marker_color
     */
    public void setMarkerColor(String markerColor) {
        this.markerColor = markerColor;
    }

    /**
     *
     * @return
     * The iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     *
     * @param iconUrl
     * The icon_url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

}