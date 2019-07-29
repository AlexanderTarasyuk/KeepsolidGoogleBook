package googlebook.books.findbook.mvp.chosenBookActivity.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import googlebook.books.findbook.mvp.chosenBookActivity.ChosenBookContract;
import googlebook.books.findbook.mvp.chosenBookActivity.ChosenBookPresenter;

@Module
public class ChosenBookModule {

    ChosenBookContract.View view;


    public ChosenBookModule(ChosenBookContract.View view) {
        this.view = view;
    }


    @Provides
    @Singleton
    ChosenBookContract.Presenter provideChosenBookPresenter(){
        return new ChosenBookPresenter(view);
    }

}
