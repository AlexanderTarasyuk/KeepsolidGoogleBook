package googlebook.books.findbook.mvp.chosenBookActivity.webView;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebClient {

    public WebClient callWebClient(WebView webView, String url){
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.canGoBack();
        webView.getProgress();
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);



        return new WebClient();
    }


}
