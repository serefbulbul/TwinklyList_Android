package co.twinkly.twinkly_list.ui.spotifysearch.mvp;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.Artist;
import co.twinkly.twinkly_list.app.model.remote.ArtistsSearch;
import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import co.twinkly.twinkly_list.ui.artistdetail.ArtistDetailActivity;
import rx.Observable;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public class SpotifySearchInteractor implements SpotifySearchContract.Interactor {

    private final Fragment fragment;
    private final SpotifyNetwork spotifyNetwork;
    private List<Artist> artists = new ArrayList<>(0);

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public SpotifySearchInteractor(Fragment fragment, SpotifyNetwork spotifyNetwork) {
        this.fragment = fragment;
        this.spotifyNetwork = spotifyNetwork;
    }

    public Observable<ArtistsSearch> searchArtist(String artist) {
        return spotifyNetwork.searchArtist(artist);
    }

    public void startArtistDetailActivity(int index) {
        fragment.getActivity().startActivity(ArtistDetailActivity.newIntent(fragment.getActivity(), artists.get(index).id()));
    }
}
