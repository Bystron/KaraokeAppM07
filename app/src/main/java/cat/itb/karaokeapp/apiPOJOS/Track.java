package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO que recoge valores dentro del campo track de la API.
public class Track {
    @SerializedName("track")
    public TrackInfo trackInfo;

    public Track(TrackInfo trackInfo) {
        this.trackInfo = trackInfo;
    }

    public TrackInfo getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(TrackInfo trackInfo) {
        this.trackInfo = trackInfo;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackInfo=" + trackInfo +
                '}';
    }
}
