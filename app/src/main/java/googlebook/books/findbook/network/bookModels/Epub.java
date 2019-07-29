package googlebook.books.findbook.network.bookModels;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity
public class Epub {
    @PrimaryKey
    @SerializedName("isAvailable")
    @Expose
    public Boolean isAvailable;

}
