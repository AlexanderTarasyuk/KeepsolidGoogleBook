package googlebook.books.findbook.mvp.chosenBookActivity.webView;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import googlebook.books.findbook.R;

public class WebViewForChosenBookLinks extends AppCompatActivity {

    @BindView(R.id.webViewBookLinks)
    WebView webView;

    WebClient webClient = new WebClient();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_for_chosen_book_links);
        ButterKnife.bind(this);

        Intent intentWebView =  getIntent();
        String url =intentWebView.getExtras().getString("webView");
        webClient.callWebClient(webView,url);

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }else {
            CookieManager.getInstance().setAcceptCookie(true);
        }

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }


}


