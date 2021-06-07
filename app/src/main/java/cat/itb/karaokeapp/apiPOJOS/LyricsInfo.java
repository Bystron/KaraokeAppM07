package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//Con este POJO podemos recoger las lyrics de cada cancion y mostrarlas al clicar en ellas.
public class LyricsInfo {
    private String lyrics_body;

    public String getLyrics_body() {
        return lyrics_body;
    }

    public void setLyrics_body(String lyrics_body) {
        this.lyrics_body = lyrics_body;
    }

    @Override
    public String toString() {
        return "Lyrics{" +
                "lyrics_body='" + lyrics_body + '\'' +
                '}';
    }
}
