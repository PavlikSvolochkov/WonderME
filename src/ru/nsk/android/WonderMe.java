package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class WonderMe extends Activity {

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    DatabaseHelper databaseHelper = new DatabaseHelper(this);
    SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    sqLiteDatabase.close();
    databaseHelper.close();
  }

  public void toWebsite(View view) {
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://wonderme.ru")));
  }

  public void toFacts(View view) {
    startActivity(new Intent(this, AllFacts.class));
  }

  public void toCategories(View view) {
    startActivity(new Intent(this, Category.class));
  }

  public void toTop(View view) {
    startActivity(new Intent(this, TopFifty.class));
  }

  public void toBoard(View view) {
    startActivity(new Intent(this, Board.class));
  }

  public void toFavorites(View view) {
    startActivity(new Intent(this, Favorites.class));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add("О приложении");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    startActivity(new Intent(this, About.class));
    return super.onOptionsItemSelected(item);
  }
}
