package co.twinkly.twinkly_list.activity.todoitems.dagger;

import android.support.v4.app.Fragment;
import android.view.View;

import co.twinkly.twinkly_list.activity.todoitems.mvp.ToDoItemsPresenter;
import co.twinkly.twinkly_list.activity.todoitems.mvp.ToDoItemsView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by serefbulbul on 28/02/2017.
 */

@Module
public class ToDoItemsModule {

    private final Fragment fragment;
    private final View view;

    public ToDoItemsModule(Fragment fragment, View view) {
        this.fragment = fragment;
        this.view = view;
    }

    @ToDoItemsScope
    @Provides
    public ToDoItemsView toDoItemsView() {
        return new ToDoItemsView(fragment, view);
    }

    @ToDoItemsScope
    @Provides
    public ToDoItemsPresenter toDoItemsPresenter() {
        return new ToDoItemsPresenter();
    }
}
