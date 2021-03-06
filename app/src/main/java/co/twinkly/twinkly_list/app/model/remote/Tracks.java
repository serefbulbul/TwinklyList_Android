package co.twinkly.twinkly_list.app.model.remote;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by serefbulbul on 09/03/2017.
 */

@AutoValue
public abstract class Tracks implements Parcelable {

    public static TypeAdapter<Tracks> typeAdapter(Gson gson) {
        return new AutoValue_Tracks.GsonTypeAdapter(gson);
    }

    @SerializedName("tracks")
    public abstract List<Track> tracks();

}