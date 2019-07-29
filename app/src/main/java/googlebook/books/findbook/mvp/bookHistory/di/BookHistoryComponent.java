package googlebook.books.findbook.mvp.bookHistory.di;

import javax.inject.Singleton;

import dagger.Subcomponent;
import googlebook.books.findbook.mvp.bookHistory.BookHistoryActivity;



@Singleton
@Subcomponent(modules = {BookHistoryModule.class})
public interface BookHistoryComponent {


        void inject(BookHistoryActivity BookHistoryActivity);

}
