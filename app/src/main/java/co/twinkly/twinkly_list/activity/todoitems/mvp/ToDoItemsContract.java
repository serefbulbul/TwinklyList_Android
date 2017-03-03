package co.twinkly.twinkly_list.activity.todoitems.mvp;

import co.twinkly.twinkly_list.activity.base.BasePresenter;
import co.twinkly.twinkly_list.activity.base.BaseView;

/**
 * Created by serefbulbul on 28/02/2017.
 */

public class ToDoItemsContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
