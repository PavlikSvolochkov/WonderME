package soap;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import database.DBHelper;
import ru.nsk.android.R;

public class SoapActivity extends Activity {

  private String TAG = "mytag";

  private DBHelper helper;
  private SQLiteDatabase database;
  private Cursor cursor;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.soap_activity);

    ContentValues cv = new ContentValues();
    CategoryParser parser = new CategoryParser();
    parser.parse(getResources().getXml(R.xml.categories));

    helper = new DBHelper(SoapActivity.this);
    database = helper.getWritableDatabase();

    long rows = 0;

    for (Category category : parser.getCategoryList()) {
      cv.put("name", category.getName());
      cv.put("facts_count", category.getFactsCount());
      rows = database.insert("categories", null, cv);
    }
    Log.d(TAG, "Number of inserted rows: " + rows);

    Log.d(TAG, "Selecting data from categories");
    cursor = database.query("categories", null, null, null, null, null, null);

    if (cursor.moveToFirst()) {
      int id = cursor.getColumnIndex("_id");
      int name = cursor.getColumnIndex("name");
      int factsCount = cursor.getColumnIndex("facts_count");
      do {
        Log.d(TAG, "ID: " + cursor.getInt(id) + " NAME: " + cursor.getString(name) + " FACTS_COUNT: " + cursor.getString(factsCount));
      } while (cursor.moveToNext());
    } else {
      Log.d(TAG, "Number of rows 0");
    }
    cursor.close();
    //database.close();
  }

  public void deleteRows(View view) {
    Log.d(TAG, "--- Clear table 'categories' ---");
    int rows = database.delete("categories", null, null);
    Log.d(TAG, "--- Rows deleted " + rows + " ---");
    Log.d(TAG, "--- Table is clear ---");
  }
}