package googlebook.books.findbook.network.bookModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Pdf {
    @SerializedName("isAvailable")
    @Expose
    public Boolean isAvailable;

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    @SerializedName("acsTokenLink")
    @Expose
    public String acsTokenLink;


}
