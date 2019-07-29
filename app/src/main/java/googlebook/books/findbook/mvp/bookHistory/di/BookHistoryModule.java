package googlebook.books.findbook.mvp.bookHistory.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import googlebook.books.findbook.mvp.bookHistory.BookHistoryContract;
import googlebook.books.findbook.mvp.bookHistory.BookHistoryPresenter;
import googlebook.books.findbook.room.dao.BookDaoInterface;

@Module
public class BookHistoryModule {

    BookHistoryContract.View view;

    public BookHistoryModule(BookHistoryContract.View view) {
        this.view = view;
    }

    @Provides
    @Singleton
   BookHistoryContract.Presenter provideBookHistoryPresenter(BookDaoInterface bookDaoInterface){
        return new BookHistoryPresenter(view,bookDaoInterface);
    }

}
