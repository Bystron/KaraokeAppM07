package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO que utilizamos para poder recoger los elementos que estan dentro del campo Body en la API.
public class Message {
    @SerializedName("body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
