package co.twinkly.twinkly_list.app.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @AppScope
    @Provides
    public Context context() {
        return context;
    }
}
