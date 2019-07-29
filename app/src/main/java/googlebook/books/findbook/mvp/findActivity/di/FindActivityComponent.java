package googlebook.books.findbook.mvp.findActivity.di;


import javax.inject.Singleton;

import dagger.Subcomponent;
import googlebook.books.findbook.mvp.findActivity.FindActivity;

@Singleton
@Subcomponent(modules = {FindActivityModule.class})
public interface FindActivityComponent {

    void inject(FindActivity findActivity);

}
