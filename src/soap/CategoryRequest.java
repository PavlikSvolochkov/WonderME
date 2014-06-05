package soap;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CategoryRequest implements Runnable {

  private String TAG = "mytag";

  private final String NAMESPACE = "http://tempuri.org/";
  private final String URL = "http://wonderme.ru/wonderme.asmx";
  private final String SOAP_ACTION = "http://tempuri.org/GetCatagories";
  private final String METHOD_NAME = "GetCatagories";

  private String envelope = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
          "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
          "  <soap:Body>\n" +
          "    <GetCatagories xmlns=\"http://tempuri.org/\">\n" +
          "      <skip>%s</skip>\n" +
          "      <take>%s</take>\n" +
          "      <account>%s</account>\n" +
          "      <deviceinfo>%s</deviceinfo>\n" +
          "    </GetCatagories>\n" +
          "  </soap:Body>\n" +
          "</soap:Envelope>";

  @Override
  public void run() {
    Log.d(TAG, callWebService(URL, SOAP_ACTION, envelope));
  }

  public String callWebService(String url, String soapAction, String envelope) {
    final DefaultHttpClient httpClient = new DefaultHttpClient();
    // параметры запроса
    Log.d(TAG, "Set HttpParams");
    HttpParams params = httpClient.getParams();
    Log.d(TAG, "Set HttpConnectionParams");
    HttpConnectionParams.setConnectionTimeout(params, 10000);
    HttpConnectionParams.setSoTimeout(params, 15000);
    // устанавливаем параметры
    Log.d(TAG, "Set HttpProtocolParams");
    HttpProtocolParams.setUseExpectContinue(httpClient.getParams(), true);

    // С помощью метода POST отправляем конверт
    Log.d(TAG, "Set HttpPost url and header");
    HttpPost httppost = new HttpPost(url);
    // и заголовки
    httppost.setHeader("soapaction", soapAction);
    httppost.setHeader("Content-Type", "text/xml; charset=utf-8");

    String responseString = "";
    try {
      // выполняем запрос
      HttpEntity entity = new StringEntity(envelope);
      httppost.setEntity(entity);
      // Заголоаок запроса
      ResponseHandler<String> rh = new ResponseHandler<String>() {
        // вызывается, когда клиент пришлет ответ
        public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
          // получаем ответ
          Log.d(TAG, "Get the response");
          HttpEntity entity = response.getEntity();
          // читаем его в массив
          Log.d(TAG, "Read the response into array");
          StringBuffer out = new StringBuffer();
          byte[] b = EntityUtils.toByteArray(entity);
          // write the response byte array to a string buffer
          out.append(new String(b, 0, b.length));
          return out.toString();
        }
      };
      responseString = httpClient.execute(httppost, rh);
    } catch (Exception e) {
      Log.d("exception", e.toString());
    }
    // закрываем соединение
    Log.d(TAG, "Close connection");
    httpClient.getConnectionManager().shutdown();
    Log.d(TAG, "Return response string");
    return responseString;
  }
}
