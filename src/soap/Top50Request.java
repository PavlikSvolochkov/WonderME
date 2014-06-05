package soap;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class Top50Request implements Runnable {

  private String TAG = "mytag";

  private final String NAMESPACE = "http://tempuri.org/";
  private final String URL = "http://wonderme.ru/wonderme.asmx";
  private final String SOAP_ACTION = "http://tempuri.org/GetFactsTop50";
  private final String METHOD_NAME = "GetFactsTop50";

  @Override
  public void run() {
    getTop50();
  }

  public void getTop50() {
    //Create request
    SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

    //Property which holds input parameters
    PropertyInfo skipInfo = new PropertyInfo();
    skipInfo.setName("skip"); //Set Name
    skipInfo.setValue(0); //Set Value
    skipInfo.setType(int.class); //Set dataType
    request.addProperty(skipInfo);

    PropertyInfo takeInfo = new PropertyInfo();
    takeInfo.setName("take");
    takeInfo.setValue(50);
    takeInfo.setType(int.class);
    request.addProperty(takeInfo);

    PropertyInfo accountInfo = new PropertyInfo();
    accountInfo.setName("account");
    accountInfo.setValue("test");
    accountInfo.setType(String.class);
    request.addProperty(accountInfo);

    PropertyInfo deviceInfo = new PropertyInfo();
    deviceInfo.setName("deviceinfo");
    deviceInfo.setValue("test");
    deviceInfo.setType(String.class);
    request.addProperty(deviceInfo); //Add the property to request object

    Log.d(TAG, request.toString());

    //Create envelope
    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

    //Set output SOAP object
    envelope.setOutputSoapObject(request);
    //Create HTTP call object
    HttpTransportSE httpTransportSE = new HttpTransportSE(URL);

    try {
      //Invole web service
      httpTransportSE.call(SOAP_ACTION, envelope);
      //Get the response
      SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
      //Assign it to fahren static variable
      Log.d(TAG, response.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
