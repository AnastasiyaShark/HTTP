package NASA;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NasasAnswer {

    @JsonProperty
    String copyright;
    @JsonProperty
    String date;
    @JsonProperty
    String explanation;
    @JsonProperty
    String hdurl;
    @JsonProperty
    String media_type;
    @JsonProperty
    String service_version;
    @JsonProperty
    String title;
    @JsonProperty
    String url;

    @Override
    public String toString() {
        return "NasasAnswer{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
