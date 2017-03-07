package co.twinkly.twinkly_list.app.network;

import java.util.List;

import co.twinkly.twinkly_list.app.model.remote.ToDoItem;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by serefbulbul on 03/03/2017.
 */

public interface ToDoNetwork {

    @GET("users/{user}/repos")
    Observable<List<ToDoItem>> getToDoItems();

    @GET("repos/{user}/{repo}")
    Observable<ToDoItem> getRepo(@Path("user") String username, @Path("repo") String repo);

    @GET("user/{user}")
    Observable<ToDoItem> getUser(@Path("user") String username);
}
