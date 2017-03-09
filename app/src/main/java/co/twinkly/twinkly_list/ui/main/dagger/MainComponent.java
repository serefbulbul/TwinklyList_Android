package co.twinkly.twinkly_list.ui.main.dagger;

import co.twinkly.twinkly_list.ui.main.MainActivity;
import dagger.Component;

/**
 * Created by serefbulbul on 03/03/2017.
 */

@MainScope
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
