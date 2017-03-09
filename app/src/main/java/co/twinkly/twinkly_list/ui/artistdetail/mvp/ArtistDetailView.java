package co.twinkly.twinkly_list.ui.artistdetail.mvp;

import android.app.Activity;
import android.support.v7.widget.AppCompatTextView;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;

/**
 * Created by serefbulbul on 07/03/2017.
 */

public class ArtistDetailView extends FrameLayout implements ArtistDetailContract.View {

    @BindView(R.id.text_view_artist_detail_track_name)
    AppCompatTextView textViewTrackName;
    @BindView(R.id.text_view_artist_detail_track_url)
    AppCompatTextView textViewTrackUrl;
    @BindView(R.id.text_view_artist_detail_track_number)
    AppCompatTextView textViewTrackNumber;

    public ArtistDetailView(Activity activity) {
        super(activity);

        inflate(getContext(), R.layout.activity_artist_detail, this);
        ButterKnife.bind(this);
    }

    public AppCompatTextView getTextViewTrackName() {
        return textViewTrackName;
    }

    public void setTrackName(String trackName) {
        textViewTrackName.setText(trackName);
    }

    public void setTrackUrl(String trackUrl) {
        textViewTrackUrl.setText(trackUrl);
    }

    public void setTrackNumber(String trackNumber) {
        textViewTrackNumber.setText(trackNumber);
    }

}
