package co.twinkly.twinkly_list.app.model.remote;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by serefbulbul on 14/02/2017.
 */

@AutoValue
public abstract class ToDoItem implements Parcelable {

    public static TypeAdapter<ToDoItem> typeAdapter(Gson gson) {
        return new AutoValue_ToDoItem.GsonTypeAdapter(gson);
    }

    public abstract String id();

    @SerializedName("name")
    public abstract String name();

}
