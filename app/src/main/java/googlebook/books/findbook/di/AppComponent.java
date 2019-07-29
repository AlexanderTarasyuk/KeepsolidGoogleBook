package googlebook.books.findbook.di;

import dagger.Component;
import googlebook.books.findbook.ApplicationScope;
import googlebook.books.findbook.mvp.bookHistory.di.BookHistoryComponent;
import googlebook.books.findbook.mvp.bookHistory.di.BookHistoryModule;
import googlebook.books.findbook.mvp.chosenBookActivity.di.ChosenBookComponent;
import googlebook.books.findbook.mvp.chosenBookActivity.di.ChosenBookModule;
import googlebook.books.findbook.mvp.findActivity.di.FindActivityComponent;
import googlebook.books.findbook.mvp.findActivity.di.FindActivityModule;

@ApplicationScope
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    FindActivityComponent plus (FindActivityModule findActivityModule);
    ChosenBookComponent plus (ChosenBookModule chosenBookModule);
    BookHistoryComponent plus (BookHistoryModule bookHistoryModule);



}
