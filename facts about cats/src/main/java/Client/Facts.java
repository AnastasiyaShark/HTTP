package Client;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Facts {
    @JsonProperty
    String _id;
    @JsonProperty
    String text;
    @JsonProperty
    String type;
    @JsonProperty
    User user;
    @JsonProperty
    int upvotes;
    @JsonProperty
    String userUpvoted;



    public int getUpvotes() {
        return upvotes;
    }

    @Override
    public String toString() {
        return "Facts{" +
                "_id='" + _id + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", upvotes=" + upvotes +
                ", userUpvoted='" + userUpvoted + '\'' +
                '}';
    }
}
