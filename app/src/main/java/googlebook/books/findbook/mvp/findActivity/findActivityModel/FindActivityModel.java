package googlebook.books.findbook.mvp.findActivity.findActivityModel;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import googlebook.books.findbook.mvp.findActivity.FindActivityContract;
import googlebook.books.findbook.network.bookModels.Items;
import googlebook.books.findbook.network.Api;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class FindActivityModel implements FindActivityModelHelper {

    @Inject
    FindActivityContract.Presenter presenter;


    private Api api;
    private List<Items> items = new ArrayList<>();
    boolean isReady = false;



    @SuppressWarnings("unchecked")
    private Observable<List<Items>> itemsObservable = Observable.fromArray(items);
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    public Observable<List<Items>> getItemsObservable() {
        return itemsObservable;
    }


    public FindActivityModel(Api api) {
        this.api = api;
    }

    public  void clearComposite(){

        compositeDisposable.clear();
}


    public List<Items>  getDataFromApi(String searchEditText) {

        searchEditText = "volumes?q=" + searchEditText;
        compositeDisposable.add(
                api.getBook(searchEditText)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                books -> {
                                    items.clear();
                                    items.addAll(books.items);

                                }
                                , Throwable::printStackTrace
                                , () -> {
                                }
                        )
        );
        return items;
    }

    @Override
    public void networkCallForData(String request) {
        request = "volumes?q=" + request;
        compositeDisposable.add(
                api.getBook(request)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                books -> {
                                    items.clear();
                                    items.addAll(books.items);

                                }
                                , Throwable::printStackTrace
                                , () -> {
                                }
                        )
        );
    }
}


