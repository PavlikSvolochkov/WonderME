package ru.nsk.android;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class BoardActivity extends ListActivity {

  private String[] names;
  private String[] titles;
  private String[] counter;
  private String[] ratings;

  private ListView lvBoard = null;
  private BoardAdapter adapter;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.board);

    lvBoard = getListView();

    names = getResources().getStringArray(R.array.names);
    titles = getResources().getStringArray(R.array.titles);
    counter = getResources().getStringArray(R.array.counts);
    ratings = getResources().getStringArray(R.array.counts);

    adapter = new BoardAdapter(this, names, titles, counter, ratings);

    lvBoard.setAdapter(adapter);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    menu.add(0, 1, 1, "Главная");
    menu.add(0, 2, 2, "Категории");
    menu.add(0, 3, 3, "Топ 50");
    menu.add(0, 4, 4, "Избранное");
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case 1:
        startActivity(new Intent(this, WonderMe.class));
        break;
      case 2:
        startActivity(new Intent(this, CategoryActivity.class));
        break;
      case 3:
        startActivity(new Intent(this, TopFiftyActivity.class));
        break;
      case 4:
        startActivity(new Intent(this, FavoritesActivity.class));
        break;
    }
    return super.onOptionsItemSelected(item);
  }

  public void reload(View view) {
    Toast.makeText(this, "Эта кнопка ничего не далет! =)", Toast.LENGTH_LONG).show();
  }

  public void back(View view) {
    onBackPressed();
  }
}
