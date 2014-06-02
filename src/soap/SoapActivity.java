package soap;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.nsk.android.R;

/**
 * Created by pkriventsov on 02.06.2014.
 */
public class SoapActivity extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.soap_activity);

    Category category;
    List<Category> categoryList = new ArrayList<>();

    XmlResourceParser parser = getResources().getXml(R.xml.categories);
    int eventType;
    try {
      eventType = parser.getEventType();
      while (eventType != XmlPullParser.END_DOCUMENT) {
        if (eventType == XmlPullParser.START_DOCUMENT) {
          Log.d("mytag", "START DOCUMENT");
        }
        if (eventType == XmlPullParser.START_TAG) {
          Log.d("mytag", "START TAG >>> " + parser.getName());
          if (parser.getName() == "Category") {
            Log.d("mytag", parser.getAttributeValue(0));
            Log.d("mytag", parser.getAttributeValue(1));
            Log.d("mytag", parser.getAttributeValue(2));
            category = new Category();
            category.setId(parser.getAttributeValue(0));
            category.setName(parser.getAttributeValue(1));
            category.setFactsCount(parser.getAttributeValue(2));
            categoryList.add(category);
          }
        }
        if (eventType == XmlPullParser.END_TAG) {
          Log.d("mytag", "END TAG");
        }
        if (eventType == XmlPullParser.TEXT) {
          Log.d("mytag", "TEXT");
        }
        eventType = parser.next();
      }
    } catch (XmlPullParserException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (Category cat : categoryList)
      Log.d("mytag", cat.toString());
  }
}