package co.twinkly.twinkly_list.app;

import android.app.Activity;
import android.app.Application;

import net.danlew.android.joda.JodaTimeAndroid;

import co.twinkly.twinkly_list.BuildConfig;
import co.twinkly.twinkly_list.app.dagger.AppComponent;
import co.twinkly.twinkly_list.app.dagger.AppModule;
import co.twinkly.twinkly_list.app.dagger.DaggerAppComponent;
import co.twinkly.twinkly_list.util.Constants;
import timber.log.Timber;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public class TwinklyListApplication extends Application {

    public static TwinklyListApplication get(Activity activity) {
        return (TwinklyListApplication) activity.getApplication();
    }

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    super.log(priority, Constants.LOGTAG, message, t);
                }
            });
        }

        JodaTimeAndroid.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent component() {
        return appComponent;
    }
}
