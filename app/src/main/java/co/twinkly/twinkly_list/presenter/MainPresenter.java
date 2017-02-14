package co.twinkly.twinkly_list.presenter;

import co.twinkly.twinkly_list.view.MainMvpView;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class MainPresenter implements Presenter<MainMvpView> {

    private MainMvpView mainMvpView;

    @Override
    public void attachView(MainMvpView view) {
        this.mainMvpView = view;
    }

    @Override
    public void detachView() {
        this.mainMvpView = null;
    }
}
