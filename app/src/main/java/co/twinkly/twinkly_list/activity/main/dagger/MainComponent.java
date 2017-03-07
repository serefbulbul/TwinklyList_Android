package co.twinkly.twinkly_list.activity.main.dagger;

import co.twinkly.twinkly_list.activity.main.MainActivity;
import dagger.Component;

/**
 * Created by serefbulbul on 03/03/2017.
 */

@MainScope
@Component(modules = {MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
