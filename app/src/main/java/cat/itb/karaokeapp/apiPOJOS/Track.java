package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO principal en el cual se recoge los dos valores que queremos de cada track de la API.
//El track_name i el artist_name. Luego, estos dos valores serian mostrador en los recycler_view si
//la API funcionara correctamente.
public class Track {

    @SerializedName("track_name")
    private String track_name;

    @SerializedName("artist_name")
    private String artist_name;

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public Track(String track_name, String artist_name) {
        this.track_name = track_name;
        this.artist_name = artist_name;
    }

    @Override
    public String toString() {
        return "Track{" +
                "track_name='" + track_name + '\'' +
                ", artist_name='" + artist_name + '\'' +
                '}';
    }
}
