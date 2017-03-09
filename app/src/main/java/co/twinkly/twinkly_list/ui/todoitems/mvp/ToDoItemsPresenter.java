package co.twinkly.twinkly_list.ui.todoitems.mvp;

/**
 * Created by serefbulbul on 28/02/2017.
 */

public class ToDoItemsPresenter implements ToDoItemsContract.Presenter {

    private final ToDoItemsView view;
    private final ToDoItemsInteractor interactor;

    public ToDoItemsPresenter(ToDoItemsView view, ToDoItemsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
