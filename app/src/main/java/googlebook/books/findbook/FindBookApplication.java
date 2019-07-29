package googlebook.books.findbook;

import android.app.Application;

import googlebook.books.findbook.di.AppComponent;
import googlebook.books.findbook.di.AppModule;
import googlebook.books.findbook.di.DaggerAppComponent;
import googlebook.books.findbook.di.DataModule;

public class FindBookApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate(){
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }


}