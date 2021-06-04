package cat.itb.karaokeapp.apiPOJOS;

public class TrackInfo {

    private String track_name;
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

    public TrackInfo(String track_name, String artist_name) {
        this.track_name = track_name;
        this.artist_name = artist_name;
    }

    @Override
    public String toString() {
        return "TrackInfo{" +
                "track_name='" + track_name + '\'' +
                ", artist_name='" + artist_name + '\'' +
                '}';
    }
}
