package co.twinkly.twinkly_list.app.dagger;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import co.twinkly.twinkly_list.app.network.SpotifyNetwork;
import co.twinkly.twinkly_list.util.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@Module
public class NetworkModule {

    @AppScope
    @Provides
    public Cache cache(Context context) {
        return new Cache(new File(context.getCacheDir(), Constants.HTTP_CACHE_DIR),
                Constants.HTTP_CACHE_SIZE);
    }

    @AppScope
    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @AppScope
    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                message -> Timber.d(message));
        return logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
    }

    @AppScope
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .client(okHttpClient)
//                .baseUrl("https://api.github.com/")
                .baseUrl("https://api.spotify.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

//    @AppScope
//    @Provides
//    public ToDoNetwork toDoNetwork(Retrofit retrofit) {
//        return retrofit.create(ToDoNetwork.class);
//    }

    @AppScope
    @Provides
    public SpotifyNetwork spotifyNetwork(Retrofit retrofit) {
        return retrofit.create(SpotifyNetwork.class);
    }

    @AppScope
    @Provides
    public Picasso picasso(Context context, OkHttpClient okHttpClient) {
        return new Picasso.Builder(context)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }
}
