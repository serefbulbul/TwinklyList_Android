package co.twinkly.twinkly_list.activity.main.mvp;

import java.util.List;

import co.twinkly.twinkly_list.app.model.local.ToDoItem;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public interface MainView extends MainContract.View {

    void showToDos(List<ToDoItem> toDoItems);

    void showMessage(int stringId);

    void showProgressView();
}
