package googlebook.books.findbook.network.bookModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class AccessInfo {
    @PrimaryKey
    @SerializedName("country")
    @NonNull
    @Expose
    public String country="";
    @SerializedName("viewability")
    @Expose
    public String viewability;
    @SerializedName("embeddable")
    @Expose
    public Boolean embeddable;
    @SerializedName("publicDomain")
    @Expose
    public Boolean publicDomain;
    @SerializedName("textToSpeechPermission")
    @Expose
    public String textToSpeechPermission;

    public Epub getEpub() {
        return epub;
    }

    @SerializedName("epub")
    @Expose
    public Epub epub;

    public Pdf getPdf() {
        return pdf;
    }

    @SerializedName("pdf")
    @Expose
    public Pdf pdf;

    public String getWebReaderLink() {
        return webReaderLink;
    }
    @SerializedName("webReaderLink")
    @Expose
    public String webReaderLink;
    @SerializedName("accessViewStatus")
    @Expose
    public String accessViewStatus;
    @SerializedName("quoteSharingAllowed")
    @Expose
    public Boolean quoteSharingAllowed;


}
