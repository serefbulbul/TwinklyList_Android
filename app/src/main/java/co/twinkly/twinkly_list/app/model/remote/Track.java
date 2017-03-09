package co.twinkly.twinkly_list.app.model.remote;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@AutoValue
public abstract class Track implements Parcelable {

    public static TypeAdapter<Track> typeAdapter(Gson gson) {
        return new AutoValue_Track.GsonTypeAdapter(gson);
    }

    @SerializedName("name")
    public abstract String name();

    @SerializedName("preview_url")
    public abstract String preview_url();

    @SerializedName("track_number")
    public abstract int track_number();

//    @SerializedName("album")
//    public abstract Album album();
}
