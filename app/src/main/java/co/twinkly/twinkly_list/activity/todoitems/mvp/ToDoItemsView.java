package co.twinkly.twinkly_list.activity.todoitems.mvp;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.app.model.remote.ToDoItem;

/**
 * Created by serefbulbul on 28/02/2017.
 */

@SuppressLint("ViewConstructor")
public class ToDoItemsView extends FrameLayout implements ToDoItemsContract.View {

    @BindView(R.id.text_view_to_do_items)
    AppCompatTextView textView;

    public ToDoItemsView(Fragment fragment, View view) {
        super(fragment.getContext());

        ButterKnife.bind(this, view);

        showMessage(1);
    }

    @Override
    public void showToDos(List<ToDoItem> toDoItems) {

    }

    @Override
    public void showMessage(int stringId) {

    }

    @Override
    public void showProgressView() {

    }

}
