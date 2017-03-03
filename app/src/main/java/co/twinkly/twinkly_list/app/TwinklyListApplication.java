package co.twinkly.twinkly_list.app;

import android.app.Activity;
import android.app.Application;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public class TwinklyListApplication extends Application {

    public static TwinklyListApplication get(Activity activity) {
        return (TwinklyListApplication) activity.getApplication();
    }
}
