package googlebook.books.findbook.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import googlebook.books.findbook.room.watchedBook.WatchedBook;
import googlebook.books.findbook.room.dao.BookDao;

@Database(entities = {WatchedBook.class}, version = 1)

@TypeConverters({Converters.class})
public abstract class WatchedBookDatabase extends RoomDatabase {
    public static final String NAME = "BookDatabase";
    public abstract BookDao bookDao();

}
