package NASA;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static final String REMOTE_SERVICE_URI = "https://api.nasa.gov/planetary/apod?api_key=L0VgCsNX0ocy0J2dX41TjFnbIsFqjjSed25Ug6Oy";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
        HttpGet requestJson = new HttpGet(REMOTE_SERVICE_URI);
        CloseableHttpResponse responseJson = httpClient.execute(requestJson);

        ObjectMapper mapper = new ObjectMapper();
        NasasAnswer javaForm = mapper.readValue(responseJson.getEntity().getContent(), NasasAnswer.class);

        HttpGet requestPic = new HttpGet(javaForm.url);
        CloseableHttpResponse responsePic = httpClient.execute(requestPic);

        String fileName;
        {
            String[] urlsParts = javaForm.url.split("/");
            fileName = urlsParts[urlsParts.length - 1];
        }

        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            InputStream istream = responsePic.getEntity().getContent();
            int length = 0;
            do {
                int available = istream.available();
                byte[] bytes = new byte[available > 0 ? available : 1];
                length = istream.read(bytes);
                fos.write(bytes, 0, bytes.length);
                System.out.printf("\navailable %d , bytes read %d , bytes length %d\n", available, length, bytes.length);
            } while (length != -1);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
