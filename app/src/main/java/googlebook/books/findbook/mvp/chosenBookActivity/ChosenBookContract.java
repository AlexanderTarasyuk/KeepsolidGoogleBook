package googlebook.books.findbook.mvp.chosenBookActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

public interface ChosenBookContract {

    interface View{


        void displayTitle(String textForTitle);

        void displayLanguage(String textForBookLanguage);

        void displayInfoLink(String textForInfoLink);

        void displayWebReaderLink(String textForWebReaderLink);

        void displayBookMaturity(String textForBookMaturity);

        void displayDownloadLink(String textForDownloadLink);

        void displayBuyLink(String textForBookBuyLink);

        void displayBookDescription(String textForDescription);

        void displayImageBook(Bitmap bitmapImage);

        void displayPriceListBook(String textForPriceList);

        void displayPriceRetailBook(String textForPriceRetailList);

        void webViewForReaderLink(String urlLink);

        void webViewForInfoLink(String urlLink);

        void webViewForDownloadLink(String urlLink);

        void showToastErrorForButtons(String errorText);

        void webViewForBuyLink(String urlLink);
    }
     interface Presenter{

         void getDataFromBundle(Bundle bundle);

         void checkIfWebReaderLinkIsCorrect(String urlWebReaderLink);
         void checkIfDownloadLinkIsCorrect(String urlLink);
         void checkIfInfoLinkIsCorrect(String urlLink);
         void checkIfBuyLinkIsCorrect(String urlLink);
     }

}
