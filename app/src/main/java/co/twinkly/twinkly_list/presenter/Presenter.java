package co.twinkly.twinkly_list.presenter;

/**
 * Created by serefbulbul on 14/02/2017.
 */

public interface Presenter <V>{

    void attachView(V view);

    void detachView();
}