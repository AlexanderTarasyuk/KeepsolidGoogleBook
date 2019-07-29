package googlebook.books.findbook.mvp.bookHistory;

import googlebook.books.findbook.room.dao.BookDaoInterface;

public class BookHistoryPresenter implements BookHistoryContract.Presenter {

   private BookHistoryContract.View view;
   private BookDaoInterface bookDaoInterface;

    public BookHistoryPresenter(BookHistoryContract.View view, BookDaoInterface bookDaoInterface) {
        this.view = view;
        this.bookDaoInterface = bookDaoInterface;
    }


}
