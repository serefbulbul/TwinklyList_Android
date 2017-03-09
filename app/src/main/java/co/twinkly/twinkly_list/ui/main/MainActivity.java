package co.twinkly.twinkly_list.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import co.twinkly.twinkly_list.ui.base.BaseActivity;
import co.twinkly.twinkly_list.ui.main.dagger.DaggerMainComponent;
import co.twinkly.twinkly_list.ui.main.dagger.MainModule;
import co.twinkly.twinkly_list.ui.main.mvp.MainPresenter;
import co.twinkly.twinkly_list.ui.main.mvp.MainView;

public class MainActivity extends BaseActivity {

    private static final String SELECTED_TAB_INDEX = "SELECTED_TAB_INDEX";

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

    public static Intent newIntent(Context context, int selectedIndex) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(SELECTED_TAB_INDEX, selectedIndex);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            view.setSelectedTabIndex(extras.getInt(SELECTED_TAB_INDEX, -1));
        }

        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
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
