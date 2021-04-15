package cat.itb.karaokeapp.webservice;

import cat.itb.karaokeapp.apiPOJOS.TrackData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServiceClient {
    @GET("track.lyrics")
    Call<TrackData> getLyrics();

    @GET()
    Call<TrackData> getLyrics(@Url String url);
}
