package co.twinkly.twinkly_list.activity.todoitems.dagger;


import co.twinkly.twinkly_list.activity.todoitems.ToDoItemsFragment;
import dagger.Component;

/**
 * Created by serefbulbul on 28/02/2017.
 */

@ToDoItemsScope
@Component(modules = {ToDoItemsModule.class})
public interface ToDoItemsComponent {

    void inject(ToDoItemsFragment fragment);

}
