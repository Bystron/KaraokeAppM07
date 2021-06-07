package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {

    //POJO que utilizamos para coger todas los elementos de track_list, que a su vez está dentro de body.

    @SerializedName("track_list")
    private List<Track> tracks;

    private LyricsInfo lyrics;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public LyricsInfo getLyrics() {
        return lyrics;
    }

    public void setLyrics(LyricsInfo lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return "Body{" +
                "tracks=" + tracks +
                '}';
    }
}
