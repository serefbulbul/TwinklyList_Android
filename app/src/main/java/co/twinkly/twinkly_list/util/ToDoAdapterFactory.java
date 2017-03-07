package co.twinkly.twinkly_list.util;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@GsonTypeAdapterFactory
public abstract class ToDoAdapterFactory implements TypeAdapterFactory {

    // Static factory method to access the package
    // private generated implementation
    public static TypeAdapterFactory create() {
        return new AutoValueGson_ToDoAdapterFactory();
    }

}