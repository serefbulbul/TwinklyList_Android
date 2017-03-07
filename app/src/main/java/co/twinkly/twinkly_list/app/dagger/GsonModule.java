package co.twinkly.twinkly_list.app.dagger;

import com.fatboyindustrial.gsonjodatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.twinkly.twinkly_list.util.ToDoAdapterFactory;
import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson gson() {
        return Converters.registerAll(new GsonBuilder())
                .registerTypeAdapterFactory(ToDoAdapterFactory.create())
                .create();
    }
}
