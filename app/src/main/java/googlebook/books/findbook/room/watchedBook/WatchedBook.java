package googlebook.books.findbook.room.watchedBook;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class WatchedBook {
    @PrimaryKey
    @NonNull
    private String bookTitle="";

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public String getBookInfolink() {
        return bookInfolink;
    }

    public String getBookWebReaderLink() {
        return bookWebReaderLink;
    }

    public String getBookMaturity() {
        return bookMaturity;
    }

    public String getBookDownload() {
        return bookDownload;
    }

    public String getBookBuyLink() {
        return bookBuyLink;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public String getListPriceAmountWithCurrencyCode() {
        return listPriceAmountWithCurrencyCode;
    }

    public String getListPriceRetailAmountWithCurrencyCode() {
        return listPriceRetailAmountWithCurrencyCode;
    }

    public String getImageByte() {
        return imageByte;
    }

    private String bookLanguage;
    private String bookInfolink;
    private String bookWebReaderLink;
    private String bookMaturity;
    private String bookDownload;
    private String bookBuyLink;
    private String bookDescription;
    private String listPriceAmountWithCurrencyCode ;
    private String listPriceRetailAmountWithCurrencyCode;
    private String imageByte;

    public WatchedBook(@NonNull String bookTitle, String bookLanguage, String bookInfolink,
                       String bookWebReaderLink, String bookMaturity, String bookDownload,
                       String bookBuyLink, String bookDescription, String listPriceAmountWithCurrencyCode,
                       String listPriceRetailAmountWithCurrencyCode, String imageByte)
    {
        this.bookTitle = bookTitle;
        this.bookLanguage = bookLanguage;
        this.bookInfolink = bookInfolink;
        this.bookWebReaderLink = bookWebReaderLink;
        this.bookMaturity = bookMaturity;
        this.bookDownload = bookDownload;
        this.bookBuyLink = bookBuyLink;
        this.bookDescription = bookDescription;
        this.listPriceAmountWithCurrencyCode = listPriceAmountWithCurrencyCode;
        this.listPriceRetailAmountWithCurrencyCode = listPriceRetailAmountWithCurrencyCode;
        this.imageByte = imageByte;
    }


}
