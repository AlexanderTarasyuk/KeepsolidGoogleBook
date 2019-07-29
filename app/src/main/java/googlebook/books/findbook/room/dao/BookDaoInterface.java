package googlebook.books.findbook.room.dao;

import java.util.List;

import googlebook.books.findbook.room.watchedBook.WatchedBook;

public interface BookDaoInterface {

    void insert(WatchedBook watchedBook);
    void delete(WatchedBook watchedBook);
    List<WatchedBook> getAllBooks();

}
