package co.twinkly.twinkly_list.ui.spotifysearch.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SpotifySearchPresenter(SpotifySearchView view, SpotifySearchInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void subscribe() {
        compositeSubscription.add(observeTextView());
        compositeDisposable.add(recyclerViewOnClick());
    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
        compositeDisposable.dispose();
    }

    private Subscription observeTextView() {
        return view.observeTextView()
                .doOnNext(__ -> {
                    view.setTextViewText("On progress..");
                    view.showProgressView(true, "On progress..");
                })
                .map(__ -> view.getArtistText())
                .observeOn(Schedulers.io())
                .switchMap(interactor::searchArtist)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach(__ -> view.setTextViewText("Completed"))
                .retry()
                .subscribe(artists -> {
                    interactor.setArtists(artists.artistsSearch().artists());
                    view.updateData(artists.artistsSearch().artists());
                    view.showProgressView(false, null);
                }, error -> {
                    System.out.print(error.getLocalizedMessage());
                    view.setTextViewText("Failed.");
                });
    }

    private Disposable recyclerViewOnClick() {
        return view.recyclerViewOnClick()
                .subscribe(interactor::startArtistDetailActivity);
    }
}
