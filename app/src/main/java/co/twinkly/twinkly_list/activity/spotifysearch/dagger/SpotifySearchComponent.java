package co.twinkly.twinkly_list.activity.spotifysearch.dagger;

import co.twinkly.twinkly_list.activity.spotifysearch.SpotifySearchFragment;
import co.twinkly.twinkly_list.app.dagger.AppComponent;
import dagger.Component;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@SpotifySearchScope
@Component(modules = {SpotifySearchModule.class}, dependencies = AppComponent.class)
public interface SpotifySearchComponent {

    void inject(SpotifySearchFragment fragment);
}
