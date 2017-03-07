package co.twinkly.twinkly_list.app.model.remote;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@AutoValue
public abstract class Artist implements Parcelable {

    public static TypeAdapter<Artist> typeAdapter(Gson gson) {
        return new AutoValue_Artist.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("href")
    public abstract String href();

    @Nullable
    @SerializedName("id")
    public abstract String id();

    @Nullable
    @SerializedName("name")
    public abstract String name();

    @SerializedName("popularity")
    public abstract int popularity();
}
