package googlebook.books.findbook.network;

import googlebook.books.findbook.network.bookModels.Answers;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "https://www.googleapis.com/books/v1/";

    @GET
    Flowable<Answers>getBook(@Url String url);

   // @GET
   // Flowable<Answers>getImage(@Url )

}
