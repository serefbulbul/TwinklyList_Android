package co.twinkly.twinkly_list.ui.todoitems.dagger;

import android.support.v4.app.Fragment;
import android.view.View;

import co.twinkly.twinkly_list.ui.todoitems.mvp.ToDoItemsInteractor;
import co.twinkly.twinkly_list.ui.todoitems.mvp.ToDoItemsPresenter;
import co.twinkly.twinkly_list.ui.todoitems.mvp.ToDoItemsView;
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
    public ToDoItemsPresenter toDoItemsPresenter(ToDoItemsView view, ToDoItemsInteractor interactor) {
        return new ToDoItemsPresenter(view, interactor);
    }

    @ToDoItemsScope
    @Provides
    public ToDoItemsInteractor toDoItemsInteractor() {
        return new ToDoItemsInteractor();
    }
}
