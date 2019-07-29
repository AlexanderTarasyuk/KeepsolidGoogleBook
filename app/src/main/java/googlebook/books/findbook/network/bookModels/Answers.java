package googlebook.books.findbook.network.bookModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Answers {

    @SerializedName("kind")
    public String kind;

    @SerializedName("totalItems")
    public int totalItems;

    public List<Items> getItems() {
        return items;
    }

    @SerializedName("items")
   public List<Items> items= new ArrayList<>();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }


}
