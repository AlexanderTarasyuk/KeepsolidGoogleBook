package googlebook.books.findbook.mvp.chosenBookActivity;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

public class ChosenBookPresenter implements ChosenBookContract.Presenter, LifecycleObserver {

    private ChosenBookContract.View view;
    private String noInformationProvidedText = "Information not provided";
    private String errorText = "Unfortunately, this option is not available for this book";


    public ChosenBookPresenter(ChosenBookContract.View view) {
        this.view = view;
        ((LifecycleOwner) view).getLifecycle().addObserver(this);
    }


    @Override
    public void getDataFromBundle(Bundle bookDataToCheck) {

        String[] keysToData = bookDataToCheck.getStringArray("KeyArray");


        passTitleToView(bookDataToCheck, keysToData[0]);
        passLanguageToView(bookDataToCheck, keysToData[1]);
        passInfoLinkToView(bookDataToCheck, keysToData[2]);
        passWebReaderLinkToView(bookDataToCheck, keysToData[3]);
        passBookMaturityToView(bookDataToCheck, keysToData[4]);
        passDownloadLinkToView(bookDataToCheck, keysToData[5]);
        passBuyLinkToView(bookDataToCheck, keysToData[6]);
        passBookDescriptionToView(bookDataToCheck, keysToData[7]);
        passBookImageToView(bookDataToCheck);
        passPriceInfoToView(bookDataToCheck, keysToData[8]);
        passPriceRetailInfoToView(bookDataToCheck, keysToData[9]);


    }

    @Override
    public void checkIfWebReaderLinkIsCorrect(String urlLink) {
        if (urlLink != null) {
            if (urlLink.startsWith("http://") || urlLink.startsWith("https://")) {
                view.webViewForReaderLink(urlLink);
            } else {
                view.showToastErrorForButtons(errorText);
            }
        } else view.showToastErrorForButtons(errorText);
    }

    @Override
    public void checkIfInfoLinkIsCorrect(String urlLink) {
        if (urlLink != null) {
            if (urlLink.startsWith("http://") || urlLink.startsWith("https://")) {
                view.webViewForInfoLink(urlLink);
            } else {
                view.showToastErrorForButtons(errorText);
            }

        }
       else view.showToastErrorForButtons(errorText);


    }

    @Override
    public void checkIfDownloadLinkIsCorrect(String urlLink) {
        if (urlLink != null) {
            if (urlLink.startsWith("http://") || urlLink.startsWith("https://")) {
                view.webViewForDownloadLink(urlLink);
            } else {
                view.showToastErrorForButtons(errorText);
            }
        } else view.showToastErrorForButtons(errorText);
    }

    @Override
    public void checkIfBuyLinkIsCorrect(String urlLink) {
        if (urlLink != null) {
            if (urlLink.startsWith("http://") || urlLink.startsWith("https://")) {
                view.webViewForBuyLink(urlLink);
            } else {
                view.showToastErrorForButtons(errorText);
            }
        } else view.showToastErrorForButtons(errorText);
    }


    private void passBookImageToView(Bundle bookDataToCheck) {
        bookDataToCheck.getByteArray("BookImageArray");
        byte[] image = bookDataToCheck.getByteArray("BookImageArray");
        Bitmap bitmapImage = BitmapFactory.decodeByteArray(image, 0, image.length);
        view.displayImageBook(bitmapImage);
    }

    private void passBookDescriptionToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForDescription;
        if (bookDataToCheck.get(keysToDatum) != null) {
            textForDescription = bookDataToCheck.getString(keysToDatum);
        } else {
            textForDescription = noInformationProvidedText;
        }
        view.displayBookDescription(textForDescription);
    }

    private void passBuyLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookBuyLink;
        if (keysToDatum != null) {
            textForBookBuyLink = bookDataToCheck.getString(keysToDatum);
        } else {
            textForBookBuyLink = noInformationProvidedText;
        }
        view.displayBuyLink(textForBookBuyLink);
    }

    private void passDownloadLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForDownloadLink;
        if (keysToDatum != null) {
            textForDownloadLink = bookDataToCheck.getString(keysToDatum);
        } else {
            textForDownloadLink = noInformationProvidedText;
        }

        view.displayDownloadLink(textForDownloadLink);
    }

    private void passBookMaturityToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookMaturity;
        if (keysToDatum != null) {
            textForBookMaturity = bookDataToCheck.getString(keysToDatum);
            textForBookMaturity = textForBookMaturity.replace("_", " ");
        } else {
            textForBookMaturity = noInformationProvidedText;
        }
        view.displayBookMaturity(textForBookMaturity);
    }

    private void passWebReaderLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForWebReaderLink;
        if (keysToDatum != null) {
            textForWebReaderLink = bookDataToCheck.getString(keysToDatum);
        } else {
            textForWebReaderLink = noInformationProvidedText;
        }
        view.displayWebReaderLink(textForWebReaderLink);
    }

    private void passInfoLinkToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForInfoLink;
        if (keysToDatum != null) {
            textForInfoLink = bookDataToCheck.getString(keysToDatum);
        } else {
            textForInfoLink = noInformationProvidedText;
        }
        view.displayInfoLink(textForInfoLink);
    }

    private void passLanguageToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForBookLanguage;
        if (keysToDatum != null) {
            textForBookLanguage = bookDataToCheck.getString(keysToDatum);
        } else {
            textForBookLanguage = noInformationProvidedText;
        }
        view.displayLanguage(textForBookLanguage);
    }

    private void passTitleToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForTitle;
        if (keysToDatum != null) {
            textForTitle = bookDataToCheck.getString(keysToDatum);
        } else {
            textForTitle = noInformationProvidedText;
        }
        view.displayTitle(textForTitle);
    }

    private void passPriceInfoToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForPriceList;
        if (keysToDatum != null) {
            textForPriceList = bookDataToCheck.getString(keysToDatum);
        } else {
            textForPriceList = noInformationProvidedText;
        }
        view.displayPriceListBook(textForPriceList);
    }

    private void passPriceRetailInfoToView(Bundle bookDataToCheck, String keysToDatum) {
        String textForPriceRetailList;
        if (keysToDatum != null) {
            textForPriceRetailList = bookDataToCheck.getString(keysToDatum);
        } else {
            textForPriceRetailList = noInformationProvidedText;
        }
        view.displayPriceRetailBook(textForPriceRetailList);
    }


}
