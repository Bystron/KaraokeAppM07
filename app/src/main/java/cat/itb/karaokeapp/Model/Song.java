package cat.itb.karaokeapp.Model;

//Model que se utilizaria para mostrar las lyrics, imagen, artista, titulo y que sonara la cancion
// si la API funcionara i no nos devolviera null en todos los valores.
public class Song {

    private String Artist;
    private String Title;
    private int img;
    private int song;
    private String lyrics;

    public Song(String artist, String title, int img, int song, String lyrics) {
        Artist = artist;
        Title = title;
        this.img = img;
        this.song = song;
        this.lyrics = lyrics;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
