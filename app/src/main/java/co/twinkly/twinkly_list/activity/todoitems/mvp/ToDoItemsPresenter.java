package co.twinkly.twinkly_list.activity.todoitems.mvp;

import javax.inject.Inject;

/**
 * Created by serefbulbul on 28/02/2017.
 */

public class ToDoItemsPresenter implements ToDoItemsContract.Presenter {

    @Inject
    ToDoItemsView view;

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
