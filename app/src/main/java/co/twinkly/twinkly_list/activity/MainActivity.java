package co.twinkly.twinkly_list.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.fragment.CompletedToDoListFragment;
import co.twinkly.twinkly_list.fragment.ToDoListFragment;
import manager.FragmentNavigationManager;

public class MainActivity extends BaseActivity {

    private static final String SELECTED_TAB_INDEX = "SELECTED_TAB_INDEX";
    private static final int TO_DO_LIST_TAB_INDEX  = FragmentNavigationManager.TAB1;
    private static final int COMPLETED_TO_DO_LIST_TAB_INDEX  = FragmentNavigationManager.TAB2;
    private static final int THREE_TAB_INDEX = FragmentNavigationManager.TAB3;
    private static final int FOUR_TAB_INDEX = FragmentNavigationManager.TAB4;
    private static final int FIVE_TAB_INDEX = FragmentNavigationManager.TAB5;

    @BindView(R.id.bottom_navigation_main)
    BottomNavigationView bottomNavigationView;

    private FragmentNavigationManager mFragmentNavigationManager;
    private List<Fragment> mFragmentList;
    private int mSelectedTabIndex;

    public static Intent newIntent(Context context, int selectedIndex) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(SELECTED_TAB_INDEX, selectedIndex);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mSelectedTabIndex = extras.getInt(SELECTED_TAB_INDEX, -1);
        }

        setBottomNavigationView();

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
    }

    private void setBottomNavigationView() {
        mFragmentList = new ArrayList(2) {{
            add(ToDoListFragment.newInstance(0));
            add(CompletedToDoListFragment.newInstance(1));
        }};

        mFragmentNavigationManager = new FragmentNavigationManager(getSupportFragmentManager(), R.id.bottom_navigation_main, mFragmentList);

        bottomNavigationView.setOnNavigationItemSelectedListener((MenuItem item) -> {

            switch (item.getItemId()) {
                case R.id.to_do_list:
                    mFragmentNavigationManager.switchTab(TO_DO_LIST_TAB_INDEX);
                case R.id.completed_to_do_list:
                    mFragmentNavigationManager.switchTab(COMPLETED_TO_DO_LIST_TAB_INDEX);
                case R.id.action_music:
                    mFragmentNavigationManager.switchTab(COMPLETED_TO_DO_LIST_TAB_INDEX);
            }

            return true;
        });
    }

}
