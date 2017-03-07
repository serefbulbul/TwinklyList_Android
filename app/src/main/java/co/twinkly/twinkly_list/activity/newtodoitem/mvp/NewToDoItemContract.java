package co.twinkly.twinkly_list.activity.newtodoitem.mvp;

import co.twinkly.twinkly_list.activity.base.BasePresenter;
import co.twinkly.twinkly_list.activity.base.BaseView;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public interface NewToDoItemContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
