package co.twinkly.twinkly_list.ui.artistdetail.dagger;

import android.app.Activity;

import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import co.twinkly.twinkly_list.ui.artistdetail.mvp.ArtistDetailInteractor;
import co.twinkly.twinkly_list.ui.artistdetail.mvp.ArtistDetailPresenter;
import co.twinkly.twinkly_list.ui.artistdetail.mvp.ArtistDetailView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 07/03/2017.
 */

@Module
public class ArtistDetailModule {

    private final Activity activity;

    public ArtistDetailModule(Activity activity) {
        this.activity = activity;
    }

    @ArtistDetailScope
    @Provides
    public ArtistDetailView artistDetailView() {
        return new ArtistDetailView(activity);
    }

    @ArtistDetailScope
    @Provides
    public ArtistDetailPresenter artistDetailPresenter(ArtistDetailView view, ArtistDetailInteractor interactor) {
        return new ArtistDetailPresenter(view, interactor);
    }

    @ArtistDetailScope
    @Provides
    public ArtistDetailInteractor artistDetailInteractor(SpotifyNetwork spotifyNetwork) {
        return new ArtistDetailInteractor(activity, spotifyNetwork);
    }
}
