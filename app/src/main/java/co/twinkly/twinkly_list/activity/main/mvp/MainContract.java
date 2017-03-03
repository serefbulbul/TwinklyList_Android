package co.twinkly.twinkly_list.activity.main.mvp;

import co.twinkly.twinkly_list.activity.base.BasePresenter;
import co.twinkly.twinkly_list.activity.base.BaseView;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public class MainContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
