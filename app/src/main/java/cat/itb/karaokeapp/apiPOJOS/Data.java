package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

//POJO que utilizamos para recoger los elementos de la API que estan dentro de message.
//Como es el campo madre que engloba a todos, lo utilizamos para hacer las peticiones a la API.
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
