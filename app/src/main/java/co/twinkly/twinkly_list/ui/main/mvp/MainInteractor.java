package co.twinkly.twinkly_list.ui.main.mvp;

import android.app.Activity;

import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.ToDoItem;
import co.twinkly.twinkly_list.app.network.ToDoNetwork;
import rx.Observable;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public class MainInteractor {

    private final Activity activity;
    private final ToDoNetwork toDoNetwork;

    public MainInteractor(Activity activity, ToDoNetwork toDoNetwork) {
        this.activity = activity;
        this.toDoNetwork = toDoNetwork;
    }

    public Observable<List<ToDoItem>> getToDoItems() {
        return toDoNetwork.getToDoItems();
    }

}
