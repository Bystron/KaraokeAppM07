package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO principal en el cual se recoge los dos valores que queremos de cada track de la API.
//El track_name i el artist_name. Luego, estos dos valores serian mostrador en los recycler_view si
//la API funcionara correctamente.
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
