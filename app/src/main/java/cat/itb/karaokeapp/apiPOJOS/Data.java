package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("message")
    Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
