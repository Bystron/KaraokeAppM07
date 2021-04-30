package cat.itb.karaokeapp.webservice;

import cat.itb.karaokeapp.apiPOJOS.Data;
import cat.itb.karaokeapp.apiPOJOS.TrackData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServiceClient {
    @GET("track.lyrics.get?format=jsonp&callback=callback&track_id=1&apikey=05ab4180ffe070543821f5ceec8cceb8")
    Call<TrackData> getLyrics();

    @GET()
    Call<TrackData> getLyrics(@Url String url);

    @GET("chart.tracks.get&apikey=05ab4180ffe070543821f5ceec8cceb8")
    Call<Data> getTracks();

    //@GET("chart.tracks.get&apikey=05ab4180ffe070543821f5ceec8cceb8")
    //Call<TrackData> getTracks();


    @GET()
    Call<TrackData> getTracks(@Url String url);
}
