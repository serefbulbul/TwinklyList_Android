package co.twinkly.twinkly_list.ui.artistdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import co.twinkly.twinkly_list.app.TwinklyListApplication;
import co.twinkly.twinkly_list.ui.artistdetail.dagger.ArtistDetailModule;
import co.twinkly.twinkly_list.ui.artistdetail.dagger.DaggerArtistDetailComponent;
import co.twinkly.twinkly_list.ui.artistdetail.mvp.ArtistDetailPresenter;
import co.twinkly.twinkly_list.ui.artistdetail.mvp.ArtistDetailView;
import co.twinkly.twinkly_list.ui.base.BaseActivity;

/**
 * Created by serefbulbul on 07/03/2017.
 */

public class ArtistDetailActivity extends BaseActivity {

    public static String SELECTED_ARTIST_ID = "SELECTED_ARTIST_ID";

    @Inject
    ArtistDetailView view;

    @Inject
    ArtistDetailPresenter presenter;

    public static Intent newIntent(Context context, String artistId) {
        Intent intent = new Intent(context, ArtistDetailActivity.class);
        intent.putExtra(SELECTED_ARTIST_ID, artistId);

        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerArtistDetailComponent.builder()
                .artistDetailModule(new ArtistDetailModule(this))
                .appComponent(TwinklyListApplication.get(this).component())
                .build().inject(this);

        setContentView(view);
        presenter.subscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.unsubscribe();
    }
}
