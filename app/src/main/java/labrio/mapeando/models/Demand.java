package labrio.mapeando.models;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Demand {


    @Expose
    @SerializedName("demands")
    public List<Demand> demands;

    @Expose
    private Integer id;
    @Expose
    private String fullname;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @Expose
    private Category category;
    @Expose
    private List<Pin> pins = new ArrayList<Pin>();
    @Expose
    private User user;


    /**
     *
     * @return
     * the demandsList
     */


    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     *
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     *
     * @param categoryId
     * The category_id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     *
     * @return
     * The category
     */
    public Category getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The pins
     */
    public List<Pin> getPins() {
        return pins;
    }

    /**
     *
     * @param pins
     * The pins
     */
    public void setPins(List<Pin> pins) {
        this.pins = pins;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

}