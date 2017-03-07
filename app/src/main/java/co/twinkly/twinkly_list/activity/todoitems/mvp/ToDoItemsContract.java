package co.twinkly.twinkly_list.activity.todoitems.mvp;

import java.util.List;

import co.twinkly.twinkly_list.activity.base.BasePresenter;
import co.twinkly.twinkly_list.activity.base.BaseView;
import co.twinkly.twinkly_list.app.model.remote.ToDoItem;

/**
 * Created by serefbulbul on 28/02/2017.
 */

public interface ToDoItemsContract {

    interface View extends BaseView<Presenter> {

        void showToDos(List<ToDoItem> toDoItems);

        void showMessage(int stringId);

        void showProgressView();
    }

    interface Presenter extends BasePresenter {

    }
}
