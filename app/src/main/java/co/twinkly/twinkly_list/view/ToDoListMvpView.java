package co.twinkly.twinkly_list.view;

import java.util.List;

import co.twinkly.twinkly_list.model.ToDoItem;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public interface ToDoListMvpView extends MvpView {

    void showToDos(List<ToDoItem> toDoItems);

    void showMessage(int stringId);

    void showProgressView();
}