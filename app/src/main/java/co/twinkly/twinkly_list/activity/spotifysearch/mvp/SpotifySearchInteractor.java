package co.twinkly.twinkly_list.activity.spotifysearch.mvp;

import android.support.v4.app.Fragment;

import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.ArtistsSearch;
import co.twinkly.twinkly_list.app.model.remote.Track;
import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import rx.Observable;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public class SpotifySearchInteractor implements SpotifySearchContract.Interactor {

    private final Fragment fragment;
    private final SpotifyNetwork spotifyNetwork;

    public SpotifySearchInteractor(Fragment fragment, SpotifyNetwork spotifyNetwork) {
        this.fragment = fragment;
        this.spotifyNetwork = spotifyNetwork;
    }

    public Observable<ArtistsSearch> searchArtist(String artist) {
        return spotifyNetwork.searchArtist(artist);
    }

    public Observable<List<Track>> getTracksForArtist(String artistId) {
        return spotifyNetwork.getTracksForArtist(artistId);
    }
}
