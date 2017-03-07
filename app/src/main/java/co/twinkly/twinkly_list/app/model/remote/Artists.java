package co.twinkly.twinkly_list.app.model.remote;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@AutoValue
public abstract class Artists implements Parcelable {

    public static TypeAdapter<Artists> typeAdapter(Gson gson) {
        return new AutoValue_Artists.GsonTypeAdapter(gson);
    }

    @SerializedName("items")
    public abstract List<Artist> artists();

}
