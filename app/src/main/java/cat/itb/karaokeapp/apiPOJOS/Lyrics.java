package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

public class Lyrics {
    @SerializedName("lyrics_body")
    private String lyrics_body;

    public String getLyrics_body() {
        return lyrics_body;
    }

    public void setLyrics_body(String lyrics_body) {
        this.lyrics_body = lyrics_body;
    }
}
