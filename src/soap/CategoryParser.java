package soap;

import android.content.res.XmlResourceParser;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class CategoryParser {

  public void parseCategory(XmlResourceParser resourceParser) throws XmlPullParserException {
    XmlResourceParser xrp = resourceParser;
    int eventType = xrp.getEventType();

    while (eventType != XmlPullParser.END_DOCUMENT) {
      if (eventType == XmlPullParser.START_DOCUMENT) {
        Log.d("mytag", "START DOCUMENT");
      }
      if (eventType == XmlPullParser.START_TAG) {
        if (xrp.getName() == "CategoryActivity")
          Log.d("mytag", xrp.getName() + ": id=" + xrp.getAttributeValue(0) + ", name=" + xrp.getAttributeValue(1)
                  + ", facts count=" + xrp.getAttributeValue(2) + "\n");
      }
    }
  }
}
