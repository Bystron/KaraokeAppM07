package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO que utilizariamos si los elementos de la lista de la API no nos devolvieran valores null.
//con este POJO podriamos recoger las lyrics de cada cancion y mostrarlas al clicar en ellas.
public class Lyrics {
    @SerializedName("lyrics_body")
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
