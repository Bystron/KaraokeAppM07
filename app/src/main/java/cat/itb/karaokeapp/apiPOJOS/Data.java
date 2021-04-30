package cat.itb.karaokeapp.apiPOJOS;

import com.google.gson.annotations.SerializedName;

public class Data {
    private String count;
    private String next;
    private String previous;
    @SerializedName("message")
    Message message;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
