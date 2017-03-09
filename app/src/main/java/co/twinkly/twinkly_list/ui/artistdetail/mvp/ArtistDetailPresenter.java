package co.twinkly.twinkly_list.ui.artistdetail.mvp;

import co.twinkly.twinkly_list.app.model.remote.Track;
import io.reactivex.disposables.CompositeDisposable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by serefbulbul on 07/03/2017.
 */

public class ArtistDetailPresenter implements ArtistDetailContract.Presenter {

    private final ArtistDetailView view;
    private final ArtistDetailInteractor interactor;
    private final CompositeSubscription compositeSubscription = new CompositeSubscription();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ArtistDetailPresenter(ArtistDetailView view, ArtistDetailInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void subscribe() {
        compositeSubscription.add(setView());
    }

    @Override
    public void unsubscribe() {
        compositeSubscription.clear();
        compositeDisposable.clear();
    }

    public Subscription setView() {
        return interactor.getTracksForArtist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(tracks -> {
                    Track track = tracks.tracks().get(0);

                    view.setTrackName(track.name());
                    view.setTrackUrl(track.preview_url());
                    view.setTrackNumber(String.valueOf(track.track_number()));
                }, error -> {
                    System.out.print(error.getLocalizedMessage());
                    view.setTrackName("Failed.");
                });
    }
}
