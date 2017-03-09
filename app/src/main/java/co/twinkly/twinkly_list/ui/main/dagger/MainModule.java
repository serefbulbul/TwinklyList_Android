package co.twinkly.twinkly_list.ui.main.dagger;

import android.app.Activity;

import co.twinkly.twinkly_list.ui.main.mvp.MainPresenter;
import co.twinkly.twinkly_list.ui.main.mvp.MainView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 03/03/2017.
 */

@Module
public class MainModule {

    private final Activity activity;

    public MainModule(Activity activity) {
        this.activity = activity;
    }

    @MainScope
    @Provides
    public MainView mainView() {
        return new MainView(activity);
    }

    @MainScope
    @Provides
    public MainPresenter mainPresenter() {
        return new MainPresenter();
    }
}
