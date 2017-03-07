package co.twinkly.twinkly_list.activity.spotifysearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.activity.base.BaseFragment;
import co.twinkly.twinkly_list.activity.spotifysearch.dagger.DaggerSpotifySearchComponent;
import co.twinkly.twinkly_list.activity.spotifysearch.dagger.SpotifySearchModule;
import co.twinkly.twinkly_list.activity.spotifysearch.mvp.SpotifySearchPresenter;
import co.twinkly.twinkly_list.activity.spotifysearch.mvp.SpotifySearchView;
import co.twinkly.twinkly_list.app.TwinklyListApplication;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public class SpotifySearchFragment extends BaseFragment {

    private static final String TAB_INDEX = "TAB_INDEX";

    @Inject
    SpotifySearchView view;

    @Inject
    SpotifySearchPresenter presenter;

    public static SpotifySearchFragment newInstance(int index) {
        SpotifySearchFragment fragment = new SpotifySearchFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_spotify_search, container, false);

        DaggerSpotifySearchComponent.builder()
                .spotifySearchModule(new SpotifySearchModule(this, view))
                .appComponent(TwinklyListApplication.get(getActivity()).component())
                .build().inject(this);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.subscribe();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        if (!hidden) {
            presenter.subscribe();
        } else {
            presenter.unsubscribe();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

//        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();

//        presenter.unsubscribe();
    }

}
