package co.twinkly.twinkly_list.ui.artistdetail.dagger;

import co.twinkly.twinkly_list.app.dagger.AppComponent;
import co.twinkly.twinkly_list.ui.artistdetail.ArtistDetailActivity;
import dagger.Component;

/**
 * Created by serefbulbul on 07/03/2017.
 */

@ArtistDetailScope
@Component (modules = {ArtistDetailModule.class}, dependencies = AppComponent.class)
public interface ArtistDetailComponent {

    void inject(ArtistDetailActivity activity);
}
