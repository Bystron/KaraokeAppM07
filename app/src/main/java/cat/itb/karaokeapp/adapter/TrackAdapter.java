package cat.itb.karaokeapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cat.itb.karaokeapp.R;
import cat.itb.karaokeapp.apiPOJOS.Track;

public class TrackAdapter extends RecyclerView.Adapter<TrackAdapter.TrackHolder>{
    private List<Track> tracks;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener{
        void onItemClick(Track name, int position);
    }

    public TrackAdapter(List<Track> tracks, OnItemClickListener listener) {
        this.tracks = tracks;
        this.itemClickListener = listener;
    }


    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TrackHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new TrackHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull TrackAdapter.TrackHolder holder, int position) {
        holder.textViewTrackName.setText(tracks.get(position).getTrack_name());
        holder.textViewArtistName.setText(tracks.get(position).getArtist_name());
        holder.textViewImage.setText(tracks.get(position).getImage());
        holder.bind(this.tracks.get(position), this.itemClickListener);
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public class TrackHolder extends RecyclerView.ViewHolder {
        TextView textViewTrackName;
        TextView textViewArtistName;
        TextView textViewImage;

        public TrackHolder(@NonNull View itemView) {
            super(itemView);
            textViewTrackName = itemView.findViewById(R.id.songTitle);
            textViewArtistName = itemView.findViewById(R.id.artistName);
            textViewImage = itemView.findViewById(R.id.albumImage);

        }
        public void bind(final Track name, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }
}