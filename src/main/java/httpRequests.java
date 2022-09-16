import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class httpRequests {

    static void sendGet(String uri) throws IOException {

        try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
            try(CloseableHttpResponse response = client.execute(new HttpGet(uri))) {
                if (response != null) {
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                }
            }
        }
    }

    //    title: 'foo',
    //    body: 'bar',
    //    userId: 1,
    static void sendPost(String uri, List<NameValuePair> params) throws IOException {

        HttpPost httpPost = new HttpPost(uri);
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        try(CloseableHttpClient client = HttpClientBuilder.create().build()) {
            try(CloseableHttpResponse response = client.execute(httpPost)) {
                if (response != null) {
                    HttpEntity entity = response.getEntity();
                    System.out.println(EntityUtils.toString(entity));
                }
            }
        }
    }
}
