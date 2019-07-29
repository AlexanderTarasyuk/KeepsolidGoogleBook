package googlebook.books.findbook.mvp.findActivity.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import googlebook.books.findbook.mvp.findActivity.FindActivityContract;
import googlebook.books.findbook.mvp.findActivity.FindActivityPresenter;
import googlebook.books.findbook.room.dao.BookDaoInterface;
import googlebook.books.findbook.network.Api;

@Module
public class FindActivityModule {

    FindActivityContract.View view;

    public FindActivityModule(FindActivityContract.View view) {

        this.view = view;

    }

    @Provides
    @Singleton
    FindActivityContract.Presenter provideFindActivityPresenter(Api api, BookDaoInterface bookDaoInterface) {
        return new FindActivityPresenter(view,api, bookDaoInterface) {
        };
    }

}
