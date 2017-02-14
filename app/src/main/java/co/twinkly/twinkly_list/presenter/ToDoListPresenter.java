package co.twinkly.twinkly_list.presenter;

import co.twinkly.twinkly_list.view.ToDoListMvpView;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class ToDoListPresenter implements Presenter<ToDoListMvpView> {

    ToDoListMvpView toDoListMvpView;

    @Override
    public void attachView(ToDoListMvpView view) {
        toDoListMvpView = view;
    }

    @Override
    public void detachView() {
        toDoListMvpView = null;
    }

}
