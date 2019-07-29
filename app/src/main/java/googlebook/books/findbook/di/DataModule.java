package googlebook.books.findbook.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import googlebook.books.findbook.ApplicationScope;
import googlebook.books.findbook.room.dao.BookDao;
import googlebook.books.findbook.network.Api;
import googlebook.books.findbook.room.WatchedBookDatabase;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {



    @Provides
    @ApplicationScope
    WatchedBookDatabase provideBookDatabase(Context context) {
        return  Room.databaseBuilder(context, WatchedBookDatabase.class,WatchedBookDatabase.NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }


    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @ApplicationScope
    Api provideApi(Retrofit retrofit){
        return retrofit.create(Api.class);
    }


    @Provides
    @ApplicationScope
    BookDao provideBookDao(WatchedBookDatabase bookDatabase){
        return bookDatabase.bookDao();
    }

}
