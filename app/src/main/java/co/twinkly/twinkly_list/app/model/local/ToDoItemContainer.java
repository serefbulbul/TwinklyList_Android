package co.twinkly.twinkly_list.app.model.local;

import java.util.ArrayList;
import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.ToDoItem;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public class ToDoItemContainer {

    private static ToDoItemContainer mInstance;
    public List<ToDoItem> toDoItems;

    private ToDoItemContainer() {
        toDoItems = new ArrayList<>();
    }

    public static synchronized ToDoItemContainer getInstance() {
        if (mInstance == null)
            mInstance = new ToDoItemContainer();
        return mInstance;
    }

    public static void removeInstance() {
        mInstance = null;
    }

}