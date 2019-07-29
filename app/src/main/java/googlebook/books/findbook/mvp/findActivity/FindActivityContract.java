package googlebook.books.findbook.mvp.findActivity;

import java.util.List;

import googlebook.books.findbook.room.watchedBook.WatchedBook;
import googlebook.books.findbook.network.bookModels.Items;

public interface FindActivityContract {

    interface View{
         void showTextAfterEditTextSearchIsEmpty();
        void setRecycler(List<Items> items);
        void setRecyclerVisible();
    }

    interface Presenter{
         void searchForTextOrBook(String searchEditText);
        void saveBookToDatabase(WatchedBook watchedBook);
    }
    interface BookListener{

        void passBookToDatabase(WatchedBook watchedBook);
    }
}
