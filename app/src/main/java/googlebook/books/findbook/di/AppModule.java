package googlebook.books.findbook.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import googlebook.books.findbook.ApplicationScope;
import googlebook.books.findbook.room.dao.BookDao;
import googlebook.books.findbook.room.dao.BookDaoInterface;

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    Context provideContext() {
        return context;
    }

    @Provides
    @ApplicationScope
    BookDaoInterface provideBookDaoInterface(BookDao bookDao) {
        return bookDao;
    }


}
