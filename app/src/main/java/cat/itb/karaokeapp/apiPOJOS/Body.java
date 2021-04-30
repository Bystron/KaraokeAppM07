package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {
    //pillar las lyrics

    //pillar las tracks
    @SerializedName("track_list")
    private List<Track> tracks;



    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Body{" +
                "tracks=" + tracks +
                '}';
    }
}
