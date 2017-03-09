package co.twinkly.twinkly_list.ui.main.mvp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.ui.completedtodoitems.CompletedToDoItemsFragment;
import co.twinkly.twinkly_list.ui.main.MainActivity;
import co.twinkly.twinkly_list.ui.spotifysearch.SpotifySearchFragment;
import co.twinkly.twinkly_list.ui.todoitems.ToDoItemsFragment;
import co.twinkly.twinkly_list.util.manager.FragmentNavigationManager;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class MainView extends FrameLayout implements MainContract.View {

    private static final int TO_DO_LIST_TAB_INDEX = FragmentNavigationManager.TAB1;
    private static final int COMPLETED_TO_DO_LIST_TAB_INDEX = FragmentNavigationManager.TAB2;
    private static final int SPOTIFY_SEARCH_TAB_INDEX = FragmentNavigationManager.TAB3;
    private static final int FOUR_TAB_INDEX = FragmentNavigationManager.TAB4;
    private static final int FIVE_TAB_INDEX = FragmentNavigationManager.TAB5;

    @BindView(R.id.bottom_navigation_main)
    BottomNavigationView bottomNavigationView;

    private FragmentNavigationManager mFragmentNavigationManager;
    private List<Fragment> mFragmentList;
    private int mSelectedTabIndex;

    public MainView(Activity activity) {
        super(activity);

        inflate(getContext(), R.layout.activity_main, this);
        ButterKnife.bind(this);

        mFragmentList = new ArrayList(3) {{
            add(ToDoItemsFragment.newInstance(0));
            add(CompletedToDoItemsFragment.newInstance(1));
            add(SpotifySearchFragment.newInstance(2));
        }};

        mFragmentNavigationManager = new FragmentNavigationManager(((MainActivity)activity).getSupportFragmentManager(), R.id.frame_layout_main, mFragmentList);

        configureBottomView();
    }

    public void setSelectedTabIndex(int mSelectedTabIndex) {
        this.mSelectedTabIndex = mSelectedTabIndex;
    }

    private void configureBottomView() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_main);

        if (mSelectedTabIndex != -1) {
            switch (mSelectedTabIndex) {
                case 0:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB1);
                    break;
                case 1:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB2);
                    break;
                case 2:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB3);
                    break;
                case 3:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB4);
                    break;
                case 4:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB5);
                    break;
                default:
                    mFragmentNavigationManager.switchTab(FragmentNavigationManager.TAB1);
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener((@NonNull MenuItem item) -> {
            switch (item.getItemId()) {
                case R.id.to_do_list:
                    mFragmentNavigationManager.switchTab(TO_DO_LIST_TAB_INDEX);
                    break;
                case R.id.completed_to_do_list:
                    mFragmentNavigationManager.switchTab(COMPLETED_TO_DO_LIST_TAB_INDEX);
                    break;
                case R.id.action_music:
                    mFragmentNavigationManager.switchTab(SPOTIFY_SEARCH_TAB_INDEX);
                    break;
            }

            return true;
        });
    }

}
