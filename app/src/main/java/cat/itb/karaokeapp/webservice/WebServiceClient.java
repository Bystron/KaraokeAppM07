package cat.itb.karaokeapp.webservice;

import cat.itb.karaokeapp.apiPOJOS.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

//Todas las llamadas a la API para todas las listas que tenemos, y la consulta con searchBar.
//También una llamada para recoger las lyrics.
public interface WebServiceClient {

    @GET()
    Call<Data> getLyrics(@Url String url);

    @GET("chart.tracks.get&page=1&page_size=8&apikey=dbeb843956759fd467bb823266c749a6")
    Call<Data> getTracks();

    @GET("chart.tracks.get?chart_name=top&page=1&country=es&page_size=8&apikey=dbeb843956759fd467bb823266c749a6")
    Call<Data> getTopTracks();

    @GET()
    Call<Data> getTracks(@Url String url);
}
