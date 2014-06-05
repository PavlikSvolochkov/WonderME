package soap;

import android.content.res.XmlResourceParser;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryParser {

  private String TAG = "mytag";

  private int catCount = 0;
  private int[] catIds = null;

  private String[] categories = null;
  private String[] factsCount = null;

  private Category category = null;
  private List<Category> categoryList = null;

  public void parse(XmlResourceParser categoryResourse) {

    XmlPullParser xpp = categoryResourse;
    try {
      categoryList = new ArrayList<>();

      while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
        switch (xpp.getEventType()) {
          // начало документа
          case XmlPullParser.START_DOCUMENT:
            Log.d(TAG, "START_DOCUMENT");
            break;
          // начало тэга
          case XmlPullParser.START_TAG:
            if (xpp.getName().equalsIgnoreCase("WondermeCategories")) {
              Log.d(TAG, "START_TAG: name = " + xpp.getName() + ", TotalRecords = " + xpp.getAttributeValue(0));
              catCount = Integer.valueOf(xpp.getAttributeValue(null, "TotalRecords"));
            }

            categories = new String[catCount];
            factsCount = new String[catCount];

            if (xpp.getName().equalsIgnoreCase("Category")) {
              Log.d(TAG, "START_TAG: name = " + xpp.getName()
                      + ", Id = " + xpp.getAttributeValue(0)
                      + ", Name = " + xpp.getAttributeValue(1)
                      + ", FactsCount = " + xpp.getAttributeValue(2));
              category = new Category();
              category.setId(xpp.getAttributeValue(0));
              category.setName(xpp.getAttributeValue(1));
              category.setFactsCount(xpp.getAttributeValue(2));
              categoryList.add(category);
            }
            break;
          // конец тэга
          case XmlPullParser.END_TAG:
            //Log.d(TAG, "END_TAG: name = " + xpp.getName());
            break;
          // содержимое тэга
          case XmlPullParser.TEXT:
            Log.d(TAG, "text = " + xpp.getText());
            break;
          default:
            break;
        }
        // следующий элемент
        xpp.next();
      }
      Log.d(TAG, "END_DOCUMENT");
    } catch (XmlPullParserException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int[] getCatIds() {
    for (int i = 0; i < categoryList.size(); i++) {
      catIds[i] = categoryList.get(i).getId();
    }
    return catIds;
  }

  public String[] getCategories() {
    for (int i = 0; i < categoryList.size(); i++) {
      categories[i] = categoryList.get(i).getName();
    }
    return categories;
  }

  public String[] getFactsCount() {
    for (int i = 0; i < categoryList.size(); i++) {
      factsCount[i] = categoryList.get(i).getFactsCount();
    }
    return factsCount;
  }

  public List<Category> getCategoryList() {
    return categoryList;
  }

  public int getCatCount() {
    return catCount;
  }
}
