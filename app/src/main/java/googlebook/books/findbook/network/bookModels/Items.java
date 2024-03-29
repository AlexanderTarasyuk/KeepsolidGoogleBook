package googlebook.books.findbook.network.bookModels;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Items {


    public String getKind() {
        return kind;
    }

    public String getId() {
        return id;
    }

    public String getEtag() {
        return etag;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public SaleInfo getSaleInfo() {
        return saleInfo;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    public void setSaleInfo(SaleInfo saleInfo) {
        this.saleInfo = saleInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    @SerializedName("kind")
    @Expose
    private String kind;


    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("etag")
    @Expose
    private String etag;


    @SerializedName("selfLink")
    @Expose
    private String selfLink;


    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;


    @SerializedName("saleInfo")
    @Expose
    private SaleInfo saleInfo;


    @SerializedName("accessInfo")
    @Expose
    private AccessInfo accessInfo;

}
