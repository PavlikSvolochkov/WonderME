package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

  private String TAG = "mytag";

  private final String TABLE_NAME = "categories";
  private final String NAME = "name";
  private final String FACTS_COUNT = "facts_count";

  public DBHelper(Context context) {
    super(context, "db", null, 1);
  }

  @Override
  public void onCreate(SQLiteDatabase database) {
    Log.d(TAG, "--- onCreate database ---");
    database.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY, " + NAME + " TEXT, " + FACTS_COUNT + " TEXT)");
    Log.d(TAG, "CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY, " + NAME + " TEXT, " + FACTS_COUNT + " TEXT)");
    Log.d(TAG, "Database was created!");
  }

  @Override
  public void onUpgrade(SQLiteDatabase database, int i, int i2) {
    database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    onCreate(database);
  }
}
