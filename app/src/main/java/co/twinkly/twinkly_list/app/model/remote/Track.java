package co.twinkly.twinkly_list.app.model.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public class Track {

    @SerializedName("name")
    public String name;

    @SerializedName("preview_url")
    public String preview_url;

    @SerializedName("track_number")
    public int track_number;

    @SerializedName("album")
    public Album album;
}
