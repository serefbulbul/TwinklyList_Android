package co.twinkly.twinkly_list.ui.spotifysearch.dagger;

import android.support.v4.app.Fragment;
import android.view.View;

import co.twinkly.twinkly_list.ui.spotifysearch.mvp.SpotifySearchInteractor;
import co.twinkly.twinkly_list.ui.spotifysearch.mvp.SpotifySearchPresenter;
import co.twinkly.twinkly_list.ui.spotifysearch.mvp.SpotifySearchView;
import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@Module
public class SpotifySearchModule {

    private final Fragment fragment;
    private final View view;

    public SpotifySearchModule(Fragment fragment, View view) {
        this.fragment = fragment;
        this.view = view;
    }

    @SpotifySearchScope
    @Provides
    public SpotifySearchView spotifySearchView() {
        return new SpotifySearchView(fragment, view);
    }

    @SpotifySearchScope
    @Provides
    public SpotifySearchPresenter spotifySearchPresenter(SpotifySearchView spotifySearchView, SpotifySearchInteractor spotifySearchInteractor) {
        return new SpotifySearchPresenter(spotifySearchView, spotifySearchInteractor);
    }

    @SpotifySearchScope
    @Provides
    public SpotifySearchInteractor spotifySearchInteractor(SpotifyNetwork spotifyNetwork) {
        return new SpotifySearchInteractor(fragment, spotifyNetwork);
    }
}
