package googlebook.books.findbook.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import googlebook.books.findbook.room.watchedBook.WatchedBook;

@Dao
public interface BookDao extends BookDaoInterface {

    @Override
    @Query("SELECT * FROM watchedbook")
    List<WatchedBook> getAllBooks();

    @Override
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(WatchedBook watchedBook);

    @Override
    @Delete
    void delete(WatchedBook watchedBook);
}
