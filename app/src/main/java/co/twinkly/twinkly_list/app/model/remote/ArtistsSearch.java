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
public abstract class ArtistsSearch implements Parcelable {

    public static TypeAdapter<ArtistsSearch> typeAdapter(Gson gson) {
        return new AutoValue_ArtistsSearch.GsonTypeAdapter(gson);
    }

    @SerializedName("artists")
    public abstract Artists artistsSearch();

}
