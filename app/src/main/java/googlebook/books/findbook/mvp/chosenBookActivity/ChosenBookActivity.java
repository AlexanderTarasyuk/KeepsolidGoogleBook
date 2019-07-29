package googlebook.books.findbook.mvp.chosenBookActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import googlebook.books.findbook.FindBookApplication;
import googlebook.books.findbook.R;
import googlebook.books.findbook.mvp.chosenBookActivity.di.ChosenBookModule;
import googlebook.books.findbook.mvp.chosenBookActivity.webView.WebViewForChosenBookLinks;

public class ChosenBookActivity extends AppCompatActivity implements ChosenBookContract.View {

    @BindView(R.id.image_chosen_book)
    ImageView imageViewChosenBook;

    @BindView(R.id.book_name)
    TextView bookName;

    @BindView(R.id.book_description)
    TextView bookDescription;

    @BindView(R.id.button_bottom_sheet_Buy)
    Button ButtonBottomSheet;

    @BindView(R.id.book_language)
    TextView bookLanguage;

    @BindView(R.id.book_maturity)
    TextView bookMaturity;

    @BindView(R.id.bottom_sheet)
    LinearLayout layoutBottomSheet;

    @BindView(R.id.valueBookPrizeNew)
    TextView valueBookPrizeNew;

    @BindView(R.id.valueBookPrizeRetail)
    TextView valueBookPrizeRetail;

    @Inject
    ChosenBookContract.Presenter presenter;


    private String urlInfoLink = "";
    private String urlWebReaderLink = "";
    private String urlDownloadLink = "";
    private String urlBuyBookLink = "";
    BottomSheetBehavior sheetBehavior;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosen_book);
        ButterKnife.bind(this);
        ((FindBookApplication) getApplication())
                .getAppComponent()
                .plus(new ChosenBookModule(this))
                .inject(this);

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        Bundle bookData = getIntent().getExtras();
        presenter.getDataFromBundle(bookData);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {

                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }


        });
    }

    @OnClick(R.id.button_bottom_sheet_Buy)
    public void toggleButtonSheet() {

        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }


    }


    @OnClick(R.id.button_book_infoLink)
    public void goToInfolink() {

        presenter.checkIfInfoLinkIsCorrect(urlInfoLink);
    }

    @OnClick(R.id.button_web_reader_link)
    public void goToWebReaderLink() {

        presenter.checkIfWebReaderLinkIsCorrect(urlWebReaderLink);


    }

    @OnClick(R.id.button_book_download)
    public void goToDownloadLink() {

        presenter.checkIfDownloadLinkIsCorrect(urlDownloadLink);

    }


    @OnClick(R.id.button_book_buy)
    public void goButtonBuyLink() {
        presenter.checkIfBuyLinkIsCorrect(urlBuyBookLink);

    }


    @Override
    public void displayTitle(String textForTitle) {
        bookName.setText(textForTitle);
    }

    @Override
    public void displayLanguage(String textForBookLanguage) {
        bookLanguage.setText(textForBookLanguage);
    }

    @Override
    public void displayInfoLink(String textForInfoLink) {
        urlInfoLink = textForInfoLink;
    }

    @Override
    public void displayWebReaderLink(String textForWebReaderLink) {
        urlWebReaderLink = textForWebReaderLink;


    }

    @Override
    public void displayBookMaturity(String textForBookMaturity) {
        bookMaturity.setText(textForBookMaturity);
    }

    @Override
    public void displayDownloadLink(String textForDownloadLink) {
        urlDownloadLink = textForDownloadLink;
    }

    @Override
    public void displayBuyLink(String textForBookBuyLink) {
        urlBuyBookLink=textForBookBuyLink;
    }

    @Override
    public void displayBookDescription(String textForDescription) {
        bookDescription.setMovementMethod(new ScrollingMovementMethod());
        bookDescription.setText(textForDescription);
    }

    @Override
    public void displayImageBook(Bitmap bitmapImage) {
        imageViewChosenBook.setImageBitmap(bitmapImage);
    }

    @Override
    public void displayPriceListBook(String textForPriceList) {
        valueBookPrizeNew.setText(textForPriceList);
    }

    @Override
    public void displayPriceRetailBook(String textForPriceRetailList) {
        valueBookPrizeRetail.setText(textForPriceRetailList);
    }

    @Override
    public void webViewForReaderLink(String urlLink) {
        Intent intentWebView = new Intent(this, WebViewForChosenBookLinks.class);
        intentWebView.putExtra("webView", urlLink);
        startActivity(intentWebView);
    }

    @Override
    public void webViewForInfoLink(String urlLink) {

        Intent intentWebView = new Intent(this, WebViewForChosenBookLinks.class);
        intentWebView.putExtra("webView", urlLink);
        startActivity(intentWebView);
    }

    @Override
    public void webViewForDownloadLink(String urlLink) {
        Intent intentWebView = new Intent(this, WebViewForChosenBookLinks.class);
        intentWebView.putExtra("webView", urlLink);
        startActivity(intentWebView);
    }

    @Override
    public void showToastErrorForButtons(String errorText) {
        Toast.makeText(getBaseContext(),errorText,Toast.LENGTH_LONG).show();
    }

    @Override
    public void webViewForBuyLink(String urlLink) {
        Intent intentWebView = new Intent(this, WebViewForChosenBookLinks.class);
        intentWebView.putExtra("webView", urlLink);
        startActivity(intentWebView);
    }




}
