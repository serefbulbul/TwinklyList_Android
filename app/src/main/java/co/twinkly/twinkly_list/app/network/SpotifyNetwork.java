package co.twinkly.twinkly_list.app.network;

import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.ArtistsSearch;
import co.twinkly.twinkly_list.app.model.remote.Track;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public interface SpotifyNetwork {

    @GET("/v1/search?type=artist")
    Observable<ArtistsSearch> searchArtist(@Query("q") String artist);

    @GET("v1/artists/{artistId}/top-tracks?country=TR")
    Observable<List<Track>> getTracksForArtist(@Path("artistId") String artistId);

}
