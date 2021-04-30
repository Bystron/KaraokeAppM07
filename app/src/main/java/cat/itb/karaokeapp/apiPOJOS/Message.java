package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

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
