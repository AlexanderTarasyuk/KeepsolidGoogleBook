package googlebook.books.findbook.mvp.chosenBookActivity.di;

import javax.inject.Singleton;

import dagger.Subcomponent;
import googlebook.books.findbook.mvp.chosenBookActivity.ChosenBookActivity;


@Singleton
@Subcomponent(modules = {ChosenBookModule.class})
public interface ChosenBookComponent {

    void inject(ChosenBookActivity chosenBookActivity);

}
