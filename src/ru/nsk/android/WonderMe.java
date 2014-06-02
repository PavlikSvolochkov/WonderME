package ru.nsk.android;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import soap.SoapActivity;

public class WonderMe extends Activity {

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
    startActivity(new Intent(this, AllFactsActivity.class));
  }

  public void toCategories(View view) {
    startActivity(new Intent(this, CategoryActivity.class));
  }

  public void toTop(View view) {
    startActivity(new Intent(this, TopFiftyActivity.class));
  }

  public void toBoard(View view) {
    startActivity(new Intent(this, BoardActivity.class));
  }

  public void toFavorites(View view) {
    startActivity(new Intent(this, FavoritesActivity.class));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add("О приложении");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    startActivity(new Intent(this, SoapActivity.class));
//    startActivity(new Intent(this, AboutActivity.class));
    return super.onOptionsItemSelected(item);
  }
}
