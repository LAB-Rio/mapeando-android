package labrio.mapeando.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pin {

    @Expose
    private Double lat;
    @SerializedName("long")
    @Expose
    private Double _long;
    @Expose
    private String fullname;

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The _long
     */
    public Double getLong() {
        return _long;
    }

    /**
     *
     * @param _long
     * The long
     */
    public void setLong(Double _long) {
        this._long = _long;
    }

    /**
     *
     * @return
     * The fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     *
     * @param fullname
     * The fullname
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

}