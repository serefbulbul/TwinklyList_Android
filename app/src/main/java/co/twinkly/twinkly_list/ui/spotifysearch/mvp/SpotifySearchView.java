package co.twinkly.twinkly_list.ui.spotifysearch.mvp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.jakewharton.rxbinding.view.RxView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.app.model.remote.Artist;
import co.twinkly.twinkly_list.ui.spotifysearch.SpotifySearchAdapter;
import io.reactivex.subjects.PublishSubject;
import rx.Observable;

/**
 * Created by serefbulbul on 06/03/2017.
 */

@SuppressLint("ViewConstructor")
public class SpotifySearchView extends FrameLayout implements SpotifySearchContract.View {

    @BindView(R.id.text_view_spotify_search)
    AppCompatTextView textView;

    @BindView(R.id.edit_text_spotify_search)
    AppCompatEditText editText;

    @BindView(R.id.recycler_view_spotify_search)
    RecyclerView recyclerView;

    private final SpotifySearchAdapter adapter;

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());

    public SpotifySearchView(Fragment fragment, View view) {
        super(fragment.getContext());

        ButterKnife.bind(this, view);

        adapter = new SpotifySearchAdapter(fragment.getContext());

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragment.getActivity()));

        editText.setText("Tarkan");
    }

    public Observable<Void> observeTextView() {
        return RxView.clicks(textView);
    }

    public void setTextViewText(String text) {
        textView.setText(text);
    }

    public String getArtistText() {
        return editText.getText().toString();
    }

    public void updateData(List<Artist> artists) {
        adapter.updateData(artists);
    }

    public PublishSubject<Integer> recyclerViewOnClick() {
        return adapter.getOnClickSubject();
    }

    public void showProgressView(boolean show, String message) {
        if (show) {
            if (message != null) {
                progressDialog.setMessage(message);
            }
            progressDialog.show();
        } else {
            progressDialog.hide();
        }
    }
}
