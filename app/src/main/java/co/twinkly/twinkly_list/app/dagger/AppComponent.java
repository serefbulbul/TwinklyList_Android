package co.twinkly.twinkly_list.app.dagger;

import android.content.Context;

import com.squareup.picasso.Picasso;

import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by serefbulbul on 03/03/2017.
 */

@AppScope
@Component (modules = {AppModule.class, NetworkModule.class, GsonModule.class})
public interface AppComponent {

    Context context();

    OkHttpClient okhttpClient();

    SpotifyNetwork spotifyNetwork();

    Picasso picasso();

}
