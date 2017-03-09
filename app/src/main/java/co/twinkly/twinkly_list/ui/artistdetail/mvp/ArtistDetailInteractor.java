package co.twinkly.twinkly_list.ui.artistdetail.mvp;

import android.app.Activity;

import co.twinkly.twinkly_list.app.model.remote.Tracks;
import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import co.twinkly.twinkly_list.ui.artistdetail.ArtistDetailActivity;
import rx.Observable;

/**
 * Created by serefbulbul on 07/03/2017.
 */

public class ArtistDetailInteractor implements ArtistDetailContract.Interactor {

    private final Activity activity;
    private final SpotifyNetwork spotifyNetwork;
    private final String artistId;

    public ArtistDetailInteractor(Activity activity, SpotifyNetwork spotifyNetwork) {
        this.activity = activity;
        this.spotifyNetwork = spotifyNetwork;

        artistId = activity.getIntent().getStringExtra(ArtistDetailActivity.SELECTED_ARTIST_ID);
    }

    public String getArtistId() {
        return artistId;
    }

    public Observable<Tracks> getTracksForArtist() {
        return spotifyNetwork.getTracksForArtist(artistId);
    }
}
