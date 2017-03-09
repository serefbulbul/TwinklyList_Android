package co.twinkly.twinkly_list.ui.spotifysearch;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.twinkly.twinkly_list.R;
import co.twinkly.twinkly_list.app.model.remote.Artist;
import co.twinkly.twinkly_list.util.OnItemSelectedListener;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by serefbulbul on 07/03/2017.
 */

public class SpotifySearchAdapter extends RecyclerView.Adapter<SpotifySearchAdapter.ViewHolder> {

    private final List<Artist> artists = new ArrayList<>(0);
    private OnItemSelectedListener mOnItemSelectedListener;
    private Context mContext;

    private PublishSubject<Integer> onClickSubject = PublishSubject.create();

    public SpotifySearchAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public PublishSubject<Integer> getOnClickSubject() {
        return onClickSubject;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_spotify_search, parent, false);

        final ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickSubject.onNext(viewHolder.getAdapterPosition());
            }
        });

//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = viewHolder.getAdapterPosition();
//                if (mOnItemSelectedListener != null && position != RecyclerView.NO_POSITION) {
//                    mOnItemSelectedListener.onItemSelected(viewHolder.itemView, 0, position);
//                }
//            }
//        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Artist artist = artists.get(position);

        holder.textViewName.setText(artist.name());
        holder.textViewDescription.setText(String.valueOf(artist.popularity()));
        holder.textViewDate.setText(artist.href());

    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void updateData(List<Artist> artists) {
        this.artists.clear();

        if (artists != null && artists.size() > 0) {
            this.artists.addAll(artists);
        }

        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_recycler_view_spotify_search_name)
        AppCompatTextView textViewName;
        @BindView(R.id.text_view_recycler_view_spotify_search_description)
        AppCompatTextView textViewDescription;
        @BindView(R.id.text_view_recycler_view_spotify_search_date)
        AppCompatTextView textViewDate;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
