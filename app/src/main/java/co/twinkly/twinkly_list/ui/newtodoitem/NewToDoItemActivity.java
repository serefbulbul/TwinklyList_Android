package co.twinkly.twinkly_list.ui.newtodoitem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.ui.base.BaseActivity;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class NewToDoItemActivity extends BaseActivity {

    private static final String SELECTED_TAB_INDEX = "SELECTED_TAB_INDEX";

    public static Intent newIntent(Context context, int selectedIndex) {
        Intent intent = new Intent(context, NewToDoItemActivity.class);
        intent.putExtra(SELECTED_TAB_INDEX, selectedIndex);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_to_do_item);
        ButterKnife.bind(this);

    }

}
