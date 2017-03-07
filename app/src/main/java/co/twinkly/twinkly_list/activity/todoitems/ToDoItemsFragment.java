package co.twinkly.twinkly_list.activity.todoitems;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.activity.base.BaseFragment;
import co.twinkly.twinkly_list.activity.todoitems.dagger.DaggerToDoItemsComponent;
import co.twinkly.twinkly_list.activity.todoitems.dagger.ToDoItemsModule;
import co.twinkly.twinkly_list.activity.todoitems.mvp.ToDoItemsPresenter;
import co.twinkly.twinkly_list.activity.todoitems.mvp.ToDoItemsView;

import static android.text.style.TtsSpan.ARG_TEXT;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class ToDoItemsFragment extends BaseFragment {

    private static final String TAB_INDEX = "TAB_INDEX";

    @Inject
    ToDoItemsView view;

    @Inject
    ToDoItemsPresenter presenter;

    private String mText;

    public static ToDoItemsFragment newInstance(int index) {
        ToDoItemsFragment fragment = new ToDoItemsFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_to_do_items, container, false);

        DaggerToDoItemsComponent.builder()
                .toDoItemsModule(new ToDoItemsModule(this, view))
                .build().inject(this);

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

    @Override
    public void onResume() {
        super.onResume();

        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();

        presenter.unsubscribe();
    }
}
