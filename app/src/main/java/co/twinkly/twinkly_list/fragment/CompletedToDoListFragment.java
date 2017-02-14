package co.twinkly.twinkly_list.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.view.CompletedToDoListMvpView;

import static android.text.style.TtsSpan.ARG_TEXT;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class CompletedToDoListFragment extends BaseFragment implements CompletedToDoListMvpView {

    private static final String TAB_INDEX = "TAB_INDEX";

    private String mText;

    public static CompletedToDoListFragment newInstance(int index) {
        CompletedToDoListFragment fragment = new CompletedToDoListFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_to_do_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (savedInstanceState == null) {
            Bundle args = getArguments();
            mText = args.getString(ARG_TEXT);
        } else {
            mText = savedInstanceState.getString(ARG_TEXT);
        }
    }

}
