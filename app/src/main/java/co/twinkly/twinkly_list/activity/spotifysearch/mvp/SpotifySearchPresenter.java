package co.twinkly.twinkly_list.activity.spotifysearch.mvp;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by serefbulbul on 06/03/2017.
 */

public class SpotifySearchPresenter implements SpotifySearchContract.Presenter {

    private final SpotifySearchView view;
    private final SpotifySearchInteractor interactor;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();

    public SpotifySearchPresenter(SpotifySearchView view, SpotifySearchInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void subscribe() {
        compositeSubscription.add(observeTextView());
    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
    }

    private Subscription observeTextView() {
        Subscription subscription = view.observeTextView()
                .doOnNext(__ -> view.setTextViewText("On progress.."))
                .map(__ -> view.getArtistText())
                .observeOn(Schedulers.io())
                .switchMap(artistName -> interactor.searchArtist(artistName))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.setTextViewText("Completed"))
                .subscribe(artists -> {
                    view.setTextViewText("Completed.");
                    view.updateData(artists.artistsSearch().artists());
                    view.setTextViewText("Listed.");
                }, error -> {
                    System.out.print(error.getLocalizedMessage());
                    view.setTextViewText("Failed.");
                });

        return subscription;
    }
}
